/*
 * Universidade Federal do Rio de Janeiro
 * Superintendência de Tecnologia da Informação - UFRJ
 * InfoTIC
 *
 * Created on 12/01/2017
 *
 */
package br.ufrj.extraquadro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import br.com.caelum.stella.bean.validation.NIT;

/**
 * Classe de modelo para Funcionarios Extraquadro.
 * 
 * @author Renato Moraes
 */
@Entity //Tabela Funcionario
public class Funcionario {

	/** Chave primária para identificar Funcionário Extraquadro */
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Auto increment
	@Column 
	private Integer id;
	
	/** Nome completo de um funcionário extraquadro. */
	@Column
	@NotBlank
	private String nome; 
	
	/** CPF de um Funcionário Extraquadro. */
	@Column
	@CPF
	private String cpf;
	
	/** PIS de um Funcionário Extraquadro. */
	@Column
	@NIT
	private String pis; 
	
	/**
	 * Instantiates a new funcionario.
	 */
	// Construtores
	public Funcionario() {
		super();
	}
	
	/**
	 * Instantiates a new funcionario.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param cpf the cpf
	 * @param pis the pis
	 */
	public Funcionario(Integer id, String nome, String cpf, String pis) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.pis = pis;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	//Getters & Setters
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the pis.
	 *
	 * @return the pis
	 */
	public String getPis() {
		return pis;
	}

	/**
	 * Sets the pis.
	 *
	 * @param pis the new pis
	 */
	public void setPis(String pis) {
		this.pis = pis;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Funcionario [id=%s, nome=%s, cpf=%s, pis=%s]", id, nome, cpf, pis);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pis == null) ? 0 : pis.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pis == null) {
			if (other.pis != null)
				return false;
		} else if (!pis.equals(other.pis))
			return false;
		return true;
	}
	
}
