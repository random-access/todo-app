package org.random_access.todo.tasks;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.random_access.todo.internationalization.LanguageBean;

@Named
@ApplicationScoped
public class TaskHandler implements Serializable {

	private static final long serialVersionUID = -6208794536836495365L;

	@Inject
	private Task currentTask;
	
	@Inject
	private LanguageBean languageBean;
	
	@EJB
	private TaskManager manager;
	
	public String addTask(){
		// currentTask needs to be cloned because JPA cannot handle proxies
		manager.save(currentTask.cloneTask());
		showMsg(FacesMessage.SEVERITY_INFO, "success", "success-adding-task");
		return "add_success";
	}

	public List<Task> getTasks() {
		return manager.getTasks();
	}

	public void deleteTask(Task task) {
		manager.remove(task);
		showMsg(FacesMessage.SEVERITY_INFO, "success", "success-removing-task");
	}

	public String updateTask(Task task) {
		manager.update(task);
		showMsg(FacesMessage.SEVERITY_INFO, "success", "success-updating-task");
		return "upd_success";
	}
	
	private void showMsg(Severity severity, String msg, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle msgBundle = ResourceBundle.getBundle("org.random_access.todo.internationalization.messages", languageBean.getLocale());
		context.addMessage("global-msgs", new FacesMessage(severity, msgBundle.getString(msg), msgBundle.getString(detail)));
		context.getExternalContext().getFlash().setKeepMessages(true);
	}
	
}
