package org.random_access.todo.internationalization;

import java.util.ResourceBundle;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("messages")
@SessionScoped
public class MessagesBean implements Serializable {

	private static final long serialVersionUID = 1416961509231874138L;
	
	@Inject
	LanguageBean languageBean;
	
	public void showInfo(String msg, String detail) {
		this._show(FacesMessage.SEVERITY_INFO, msg, detail);
	}
	
	public void showWarning (String msg, String detail) {
		this._show(FacesMessage.SEVERITY_WARN, msg, detail);
	}
	
	public void showError (String msg, String detail) {
		this._show(FacesMessage.SEVERITY_ERROR, msg, detail);
	}
	
	public void showFatal (String msg, String detail) {
		this._show(FacesMessage.SEVERITY_FATAL, msg, detail);
	}
	
	private void _show(Severity severity, String msg, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle msgBundle = ResourceBundle.getBundle("org.random_access.todo.internationalization.messages", languageBean.getLocale());
		context.addMessage("global-msgs", new FacesMessage(severity, msgBundle.getString(msg), msgBundle.getString(detail)));
		context.getExternalContext().getFlash().setKeepMessages(true);
	}
	
}
