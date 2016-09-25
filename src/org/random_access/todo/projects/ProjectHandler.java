package org.random_access.todo.projects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ProjectHandler implements Serializable {

	private static final long serialVersionUID = -5826428036095257366L;
	
	@EJB
	private ProjectManager manager;


	public List<Project> getProjects() {
		return manager.getProjects();
	}

	/**
	 * Finds a project by its ID and returns it.
	 * @param id project id
	 * @return the project, if a project with that ID exists
	 */
	public Project getProject(int id) {
		return manager.getProject(id);
	}
	
	public List<SelectItem> getProjectSelection() {
		List<SelectItem> selection = new ArrayList<>();
		for (Project p : getProjects()) {
			selection.add(new SelectItem(p, p.getName()));
		}
		return selection;
	}
}
