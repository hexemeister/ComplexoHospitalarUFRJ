package persistence;

import java.util.List;

import model.Funcionario;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

// TODO: Auto-generated Javadoc
/**
 * DAO para manipular Funcionario na base de dados.
 */
public class FuncionarioDao {

	/** The session. */
	Session session;
	
	/** The criteria. */
	Criteria criteria;
	
	/** The transaction. */
	Transaction transaction;
	
	/** The query. */
	Query query;
	
	/**
	 * Cadastrar.
	 *
	 * @param f the f
	 * @throws Exception the exception
	 */
	public void cadastrar(Funcionario f)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
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
	public void update(Funcionario f)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
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
		session = HibernateUtil.getSessionFactory().openSession();
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
		session = HibernateUtil.getSessionFactory().openSession();
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
		session = HibernateUtil.getSessionFactory().openSession();
		Funcionario f = (Funcionario) session.get(Funcionario.class, id);
		session.close();
		return f;
	}
	
}
