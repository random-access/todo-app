package org.random_access.todo.projects;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter("ProjectConverter")
@Named
public class ProjectConverter implements Converter {
	
	private ProjectHandler projectHandler;
	
	public ProjectConverter() {
		// can't inject CDI beans into FacesConverter
		// See: http://stackoverflow.com/questions/7531449/cdi-injection-into-a-facesconverter
		this.projectHandler = CDI.current().select(ProjectHandler.class).get();
	}
	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return value == null || value.length() == 0 ? null : projectHandler.getProject(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return value == null ? "" : String.valueOf(((Project) value).getId());
	}

}
