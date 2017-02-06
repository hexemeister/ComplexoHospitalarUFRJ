package br.ufrj.extraquadro.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public abstract class GenericDAO<T extends BaseEntity, ID extends Serializable> {
	private Class<T> persistentClass;
	private EntityManager em;

	public GenericDAO(Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
		em = HibernateUtil.getEntityManager();
	}
	
	public void save(T entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (IllegalStateException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void update(T entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (IllegalStateException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void delete(T entity) {
		try {
			T copy = em.find(persistentClass, entity.getId());
			em.getTransaction().begin();
			em.remove(copy);
			em.getTransaction().commit();
		} catch (IllegalStateException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public List<T> listAll() {
		TypedQuery<T> query = em.createNamedQuery("SELECT a FROM " + persistentClass.getName() + " a", persistentClass);
		return query.getResultList();
	}
	
	public T findById(ID id) {
		return em.find(persistentClass, id);
	}

}
