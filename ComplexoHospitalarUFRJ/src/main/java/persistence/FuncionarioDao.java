package persistence;

import java.util.List;

import model.Funcionario;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

public class FuncionarioDao {

	Session session;
	Criteria criteria;
	Transaction transaction;
	Query query;
	
	public void cadastrar(Funcionario f)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(f);
		transaction.commit();
		session.close();
	}
	
	public void update(Funcionario f)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(f);
		transaction.commit();
		session.close();
	}
	
	public void delete(Funcionario f)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(f);
		transaction.commit();
		session.close();
	}
	
	public List<Funcionario> listar()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Funcionario.class);
		criteria.addOrder(Order.asc("nome"));
		List<Funcionario> lista = criteria.list();
		session.close();
		return lista;
	}
	
	public Funcionario buscarId(Integer id)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		Funcionario f = (Funcionario) session.get(Funcionario.class, id);
		session.close();
		return f;
	}
	
}
