package br.ufrj.extraquadro.persistence;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.ufrj.extraquadro.model.Funcionario;

// TODO: Auto-generated Javadoc
/**
 * DAO para manipular Funcionario na base de dados.
 */
public class FuncionarioDao implements Serializable {

	@Inject
	private EntityManager manager;
	
	/** The session. */
	
	
	/** The criteria. */
	Criteria criteria;
	
	/** The transaction. */
	Transaction transaction;
	
	/**
	 * Cadastrar.
	 *
	 * @param f the f
	 * @throws Exception the exception
	 */
	public void cadastrar(Funcionario f) throws Exception{
		Session session = manager.unwrap(Session.class);
		transaction = session.beginTransaction();
		session.save(f);
		transaction.commit();
		session.close();
	}
	
	/**
	 * Update.
	 *
	 * @param f the f
	 * @throws Exception the exception
	 */
	public void update(Funcionario f) throws Exception{
		Session session = manager.unwrap(Session.class);
		transaction = session.beginTransaction();
		session.update(f);
		transaction.commit();
		session.close();
	}
	
	/**
	 * Delete.
	 *
	 * @param f the f
	 * @throws Exception the exception
	 */
	public void delete(Funcionario f)throws Exception{
		Session session = manager.unwrap(Session.class);
		transaction = session.beginTransaction();
		session.delete(f);
		transaction.commit();
		session.close();
	}
	
	/**
	 * Listar.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Funcionario> listar()throws Exception{
		System.out.println("++++ "+manager.toString());
		Session session = manager.unwrap(Session.class);
		criteria = session.createCriteria(Funcionario.class);
		criteria.addOrder(Order.asc("nome"));
		List<Funcionario> lista = criteria.list();
		session.close();
	
		return lista;
	}
	
	/**
	 * Buscar id.
	 *
	 * @param id the id
	 * @return the funcionario
	 * @throws Exception the exception
	 */
	public Funcionario buscarId(Integer id)throws Exception{
		Session session = manager.unwrap(Session.class);
		Funcionario f = (Funcionario) session.get(Funcionario.class, id);
		session.close();
		return f;
	}
	
}
