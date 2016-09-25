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
	
	public Project getProject(int id) {
		return em.find(Project.class, id);
	}
	
	public List<Project> getProjects() {
		TypedQuery<Project> query = em.createNamedQuery("find_all_projects", Project.class);
		return query.getResultList();
	}
	
	public Project save(Project project) {
		em.persist(project);
		return project;
	}
	
	public Project update(Project project) {
		em.merge(project);
		return project;
	}
	
	
	public void remove(Project project) throws ProjectException {
		try {
			em.remove(em.merge(project));
			em.flush();
		} catch (Exception e) {
			// TODO: specific error messages & localization
			throw new ProjectException(e.getMessage());	
		} 
	}

}
