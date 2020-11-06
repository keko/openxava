
// File generated by OpenXava: Fri Nov 06 11:20:11 CET 2020
// Archivo generado por OpenXava: Fri Nov 06 11:20:11 CET 2020

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Month		Entity/Entidad

package org.openxava.test.model;

import java.util.*;
import java.math.*;
import java.rmi.RemoteException;
import org.openxava.component.MetaComponent;
import org.openxava.model.meta.MetaModel;
import org.openxava.util.*;

/**
 * 
 * @author MCarmen Gimeno
 */
public class Month implements java.io.Serializable, org.openxava.test.model.IMonth {	

	// Constructor
	public Month() {
		initMembers();
	} 

	private void initMembers() { 
		setName(null); 
		setDays(0); 	
	} 
	
	// Properties/Propiedades 
	private static org.openxava.converters.IConverter nameConverter;
	private org.openxava.converters.IConverter getNameConverter() {
		if (nameConverter == null) {
			try {
				nameConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("name");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "name"));
			}
			
		}	
		return nameConverter;
	} 
	private java.lang.String name;
	private java.lang.String get_Name() {
		return name;
	}
	private void set_Name(java.lang.String newName) {
		this.name = newName;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getName() {
		try {
			return (String) getNameConverter().toJava(get_Name());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "Month", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setName(String newName) {
		try { 
			set_Name((java.lang.String) getNameConverter().toDB(newName));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "Month", "String"));
		}		
	} 
	private static org.openxava.converters.IConverter daysConverter;
	private org.openxava.converters.IConverter getDaysConverter() {
		if (daysConverter == null) {
			try {
				daysConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("days");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "days"));
			}
			
		}	
		return daysConverter;
	} 
	private java.lang.Integer days;
	private java.lang.Integer get_Days() {
		return days;
	}
	private void set_Days(java.lang.Integer newDays) {
		this.days = newDays;
	} 	
	
	/**
	 * 
	 * 
	 */
	public int getDays() {
		try {
			return ((Integer) getDaysConverter().toJava(get_Days())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Days", "Month", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setDays(int newDays) {
		try { 
			set_Days((java.lang.Integer) getDaysConverter().toDB(new Integer(newDays)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Days", "Month", "int"));
		}		
	} 

	// References/Referencias 

	// Colecciones/Collections 

	// Methods/Metodos 	

	// User defined finders/Buscadores definidos por el usuario 	
 	public static Month findBy() throws javax.ejb.ObjectNotFoundException {
		org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Month as o"); 
		Month r = (Month) query.uniqueResult();
		if (r == null) {
			throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Month"));
		}
		return r; 
 	} 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Month").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		try {
			return getMetaModel().toString(this);
		}
		catch (XavaException ex) {
			System.err.println(XavaResources.getString("toString_warning", "Month"));
			return super.toString();
		}		
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}