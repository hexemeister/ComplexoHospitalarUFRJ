package br.ufrj.extraquadro.persistence;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufrj.extraquadro.model.Funcionario;

// TODO: Auto-generated Javadoc
/**
 * DAO para manipular Funcionario na base de dados.
 */
public class FuncionarioDao implements Serializable {

	private static final long serialVersionUID = -1230905105476478857L;

	@Inject
	private EntityManager manager;

	/**
	 * Cadastrar.
	 *
	 * @param f
	 *            the f
	 * @throws Exception
	 *             the exception
	 */
	public void cadastrar(Funcionario f) throws Exception {
		manager.getTransaction().begin();
		manager.persist(f);
		manager.getTransaction().commit();
	}

	/**
	 * Update.
	 *
	 * @param f
	 *            the f
	 * @throws Exception
	 *             the exception
	 */
	public void update(Funcionario f) throws Exception {
		manager.getTransaction().begin();
		f = manager.find(Funcionario.class, f.getId());
		manager.merge(f);
		manager.getTransaction().commit();
	}

	/**
	 * Delete.
	 *
	 * @param f
	 *            the f
	 * @throws Exception
	 *             the exception
	 */
	public void delete(Funcionario f) throws Exception {
		manager.getTransaction().begin();
		manager.remove(f);
		manager.getTransaction().commit();
	}

	/**
	 * Listar.
	 *
	 * @return the list
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("unchecked")
	public List<Funcionario> listar() throws Exception {
		String query = "SELECT f FROM Funcionario f order by f.nome ASC";
		List<Funcionario> resultList = (List<Funcionario>) manager.createQuery(query)
				.getResultList();
		List<Funcionario> lista = resultList;
		return lista;
	}

	/**
	 * Buscar id.
	 *
	 * @param id
	 *            the id
	 * @return the funcionario
	 * @throws Exception
	 *             the exception
	 */
	public Funcionario buscarId(Integer id) throws Exception {
		Funcionario f = (Funcionario) manager.find(Funcionario.class, id);
		return f;
	}

}
