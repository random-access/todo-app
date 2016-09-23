package org.random_access.todo.store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.random_access.todo.model.TaskBean;

@ApplicationScoped
public class TaskHandler implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Task> taskList;
	
	public TaskHandler () {
		taskList = new ArrayList<>();
	}
	
	public void addTask(TaskBean taskBean){
		Task task = new Task(taskBean.getName(), taskBean.getDescription(), taskBean.getProject());
		taskList.add(task);
	}

	public List<Task> getTasks() {
		return taskList;
	}
	
	
}
