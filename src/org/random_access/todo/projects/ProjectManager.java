package org.random_access.todo.projects;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ProjectManager {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public List<Project> getProjects() {
		TypedQuery<Project> query = em.createQuery("from Project", Project.class);
		return query.getResultList();
	}
	
	public Project getProject(int id) {
		return em.find(Project.class, id);
	}

}
