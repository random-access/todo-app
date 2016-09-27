package org.random_access.todo.projects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.random_access.todo.internationalization.MessagesBean;

@Named
@ApplicationScoped
public class ProjectHandler implements Serializable {

	private static final long serialVersionUID = -5826428036095257366L;
	
	@Inject
	private Project currentProject;
	
	@Inject
	private MessagesBean messages;
	
	@EJB
	private ProjectManager manager;

	public String addProject(){
		// currentProject needs to be cloned because JPA cannot handle proxies
		manager.save(currentProject.cloneProject());
		messages.showInfo("success", "success-adding-project");
		return "add_success";
	}

	public List<Project> getProjects() {
		return manager.getProjects();
	}

	public Project getProject(int id) {
		return manager.getProject(id);
	}
	
	public void deleteProject(Project project) {
		try {
			manager.remove(project);
			messages.showInfo("success", "success-removing-project");
		} catch (ProjectException e) {
			FacesMessage msg = new FacesMessage(e.getMessage());
			messages.showError("error", "error-removing-project");
		}
	}

	public String updateProject(Project project) {
		manager.update(project);
		return "upd_success";
	}
	
	// Get projects as list of SelectItem for dropdowns,...
	public List<SelectItem> getProjectSelection() {
		List<SelectItem> selection = new ArrayList<>();
		for (Project p : getProjects()) {
			selection.add(new SelectItem(p, p.getName()));
		}
		return selection;
	}

}
