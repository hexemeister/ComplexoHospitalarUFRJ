package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Tabela Funcionario
public class Funcionario {

	@Id //Chave Primaria
	@GeneratedValue(strategy=GenerationType.AUTO) //Auto increment
	@Column //?Coluna
	private Integer id;
	@Column
	private String nome;
	@Column
	private Double salario;
	public Funcionario(Integer id, String nome, Double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}
	public Funcionario() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
}
