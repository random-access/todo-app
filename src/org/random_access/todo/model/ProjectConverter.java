package org.random_access.todo.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter("ProjectConverter")
@Named
public class ProjectConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return Project.valueOf(Project.class, value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Project project = (Project) value;
		switch(project) {
			case personal:
				return "Privat";
			case uni:
				return "Uni";
			case work:
				return "Arbeit";
			default:
				return "Unbekannt";
		}
	}

}
