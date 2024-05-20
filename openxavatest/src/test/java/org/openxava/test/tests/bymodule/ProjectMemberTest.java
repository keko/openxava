package org.openxava.test.tests.bymodule;

import org.openxava.tests.*;

/**
 *  
 * @author Javier Paniza
 */

public class ProjectMemberTest extends ModuleTestBase {
	
	public ProjectMemberTest(String testName) {
		super(testName, "ProjectMember");		
	}
	
	public void testSetReferenceUsedInMappedByOfOrderColumnList() throws Exception {
		execute("CRUD.new");
		setValue("name", "JUNIT PROJECT MEMBER");
		execute("Reference.search", "keyProperty=project.name");
		assertValueInList(0, 0, "THE BIG PROJECT"); 
		execute("ReferenceSearch.choose", "row=0");
		assertValue("project.name", "THE BIG PROJECT");
		execute("CRUD.save");
		assertNoErrors();
		
		changeModule("Project");
		execute("List.viewDetail", "row=0");
		assertValue("name", "THE BIG PROJECT");
		assertCollectionRowCount("members", 4);
		assertValueInCollection("members", 0, 0, "JOHN"); 
		assertValueInCollection("members", 1, 0, "JUAN");
		assertValueInCollection("members", 2, 0, "PETER");
		assertValueInCollection("members", 3, 0, "JUNIT PROJECT MEMBER");
		
		changeModule("ProjectMember");
		setValue("name", "JUNIT PROJECT MEMBER");
		execute("CRUD.refresh");
		assertValue("project.name", "THE BIG PROJECT");
		execute("CRUD.delete");
		assertNoErrors();
	}
	
	public void testUpdateEntityUsedInOrderColumnList() throws Exception { 
		execute("List.orderBy", "property=name");
		assertValueInList(0, 0, "JOHN");
		execute("List.viewDetail", "row=0");
		assertValue("name", "JOHN");
		execute("CRUD.save");
		assertNoErrors();
		
		changeModule("Project");
		execute("List.viewDetail", "row=0");
		assertValue("name", "THE BIG PROJECT");
		assertCollectionRowCount("members", 3); 
		assertValueInCollection("members", 0, 0, "JOHN");
		assertValueInCollection("members", 1, 0, "JUAN");
		assertValueInCollection("members", 2, 0, "PETER");		
	}
	
	public void testAddedExistingEntitiesToOrderColumnListFromEntityModule() throws Exception {  
		execute("List.orderBy", "property=name");
		assertValueInList(0, 0, "JOHN");
		assertValueInList(1, 0, "JUAN");
		execute("List.viewDetail", "row=0");
		assertValue("name", "JOHN");
		assertValue("team.name", "");
		execute("Reference.search", "keyProperty=team.name");
		execute("ReferenceSearch.choose", "row=0");
		assertValue("team.name", "PROGRAMMERS");
		execute("CRUD.save");
		assertNoErrors();
		
		execute("Navigation.next");
		assertValue("name", "JUAN");
		assertValue("team.name", "");
		execute("Reference.search", "keyProperty=team.name");
		execute("ReferenceSearch.choose", "row=0");
		assertValue("team.name", "PROGRAMMERS");
		execute("CRUD.save");		
		
		changeModule("ProjectTeam");
		execute("List.viewDetail", "row=0");
		assertValue("name", "PROGRAMMERS");
		assertCollectionRowCount("members", 2); 
		assertValueInCollection("members", 0, 0, "JOHN");
		assertValueInCollection("members", 1, 0, "JUAN");
		
		changeModule("ProjectMember");
		execute("Navigation.first");
		assertValue("name", "JOHN");
		assertValue("team.name", "PROGRAMMERS");
		execute("Reference.clear", "keyProperty=team.name");
		assertValue("team.name", "");
		execute("CRUD.save");		
		
		changeModule("ProjectTeam");
		assertValue("name", "PROGRAMMERS");
		assertCollectionRowCount("members", 1); 
		assertValueInCollection("members", 0, 0, "JUAN");
		
		// Cleaning data
		checkAllCollection("members");
		execute("Collection.removeSelected", "viewObject=xava_view_members");
		assertCollectionRowCount("members", 0);
	}
			
}
