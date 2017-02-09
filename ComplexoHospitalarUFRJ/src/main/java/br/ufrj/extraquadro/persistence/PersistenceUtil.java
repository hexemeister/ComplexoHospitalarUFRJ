package br.ufrj.extraquadro.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class PersistenceUtil {

	static final String PERSISTENCE_UNIT= "ExtraQuadroUFRJ";
	
	private EntityManagerFactory factory;
	
	public PersistenceUtil() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}
	
	@Produces @RequestScoped
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	
//	private static SessionFactory sessionFactory = buildSessionFactory();
//	private static ThreadLocal<EntityManager> threadLocal = new ThreadLocal<>();

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

	public static void closeEntityManager(@Disposes EntityManager manager) {
//		getSessionFactory().close();
		if (manager.isOpen()) {
            manager.close();
        }
	}

//	public static EntityManager getEntityManager() {
//		EntityManager em = threadLocal.get();
//		if (em == null) {
//			em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
//			threadLocal.set(em);
//		}
//		return em;
//	}
}
