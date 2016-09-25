package org.random_access.todo.tasks;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class TaskManager {
	
	@PersistenceContext
	private EntityManager em;
	
	public Task getTask(int id) {
		return em.find(Task.class, id);
	}
	
	public List<Task> getTasks() {
		TypedQuery<Task>  query = em.createNamedQuery("find_all_tasks", Task.class);
		return query.getResultList();
	}
	
	public Task save(Task task) {
		em.persist(task);
		return task;
	}
	
	public Task update(Task task) {
		em.merge(task);
		return task;
	}
	
	
	public void remove(Task task) {
		em.remove(em.merge(task));
	}

}
