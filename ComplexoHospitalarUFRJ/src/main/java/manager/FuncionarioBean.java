package manager;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import persistence.FuncionarioDao;
import model.Funcionario;

@ManagedBean(name="fbean")
@RequestScoped
public class FuncionarioBean {

	private Funcionario f;
	private List<Funcionario> lista;
	private Funcionario f2;
	
	public FuncionarioBean() {
		f = new Funcionario();
		lista = new ArrayList<Funcionario>();
		f2 = new Funcionario();
	}
	
	
	public Funcionario getF2() {
		return f2;
	}


	public void setF2(Funcionario f2) {
		this.f2 = f2;
	}


	public List<Funcionario> getLista() {
		try{
			lista = new FuncionarioDao().listar();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}

	public void setLista(List<Funcionario> lista) {
		this.lista = lista;
	}

	public Funcionario getF() {
		return f;
	}

	public void setF(Funcionario f) {
		this.f = f;
	}
	
	public String cadastrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try{
			new FuncionarioDao().cadastrar(f);
			fc.addMessage(null, new FacesMessage("Funcionario cadastrado com sucesso!"));
			//limpar o formulario
			f = new Funcionario();
		}catch(Exception e){
			fc.addMessage(null, new FacesMessage("Funcionario nao cadastrado!"));
		}
		
		//Cadastrar e ficar na mesma tela que executou o metodo
		return null;
	}
	
	public String excluir(){
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try{
			new FuncionarioDao().delete(f2);
			f2 = new Funcionario();
			fc.addMessage(null, new FacesMessage("Funcionario excluido com sucesso!"));
		}catch(Exception e){
			fc.addMessage(null, new FacesMessage("Funcionario nao excluido!"));
		}
		
		//Cadastrar e ficar na mesma tela que executou o metodo
		return null;
	}
	
	public String detalhes(){
		try{
			if(f2 != null)
				return "editar";
			else
				return "cadastrar";
		}catch(Exception e){
			e.printStackTrace();
			return "cadastrar";
		}
	}
	
	public String editar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try{
			new FuncionarioDao().update(f2);
			fc.addMessage(null, new FacesMessage("Funcionario editad"));
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return "cadastrar";
	}
}
