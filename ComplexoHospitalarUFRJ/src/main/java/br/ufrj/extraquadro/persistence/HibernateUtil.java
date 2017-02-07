package br.ufrj.extraquadro.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * [[SuppressWarningsSpartan]]
 */
public class HibernateUtil {

//	private static SessionFactory sessionFactory = buildSessionFactory();
	private static ThreadLocal<EntityManager> threadLocal = new ThreadLocal<>();

//	private static SessionFactory buildSessionFactory() {
//		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//		try {
//			return new MetadataSources(registry).buildMetadata().buildSessionFactory();
//
//			//			return sessionFactory;
//
//		} catch (Throwable ex) {
//			ex.printStackTrace();
//			StandardServiceRegistryBuilder.destroy( registry );
//			throw new ExceptionInInitializerError(ex);
//		}
//	}

//	public static SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}

	public static void shutdown() {
//		getSessionFactory().close();
		getEntityManager().close();
	}

	public static EntityManager getEntityManager() {
		EntityManager em = threadLocal.get();
		if (em == null) {
			em = Persistence.createEntityManagerFactory("ExtraQuadroUFRJ").createEntityManager();
			threadLocal.set(em);
		}
		return em;
	}
}
