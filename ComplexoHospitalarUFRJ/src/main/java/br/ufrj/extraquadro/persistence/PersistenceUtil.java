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

	static final String PERSISTENCE_UNIT = "ExtraQuadroUFRJ";

	private EntityManagerFactory factory;

	public PersistenceUtil() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}

	public static void closeEntityManager(@Disposes EntityManager manager) {
		if (manager.isOpen()) {
			System.out.println("++++ fechou");
			manager.close();
		}
	}
}
