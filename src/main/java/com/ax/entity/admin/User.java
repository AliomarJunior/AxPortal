package com.ax.entity.admin;

import java.sql.Date;

/**
 * Classe que representa o usuario logado no sistema.
 * 
 * @author Aliomar Junior
 *
 */
public class User {

	private Long id;
	private String nome;
	private String password;
	private Date dateCreated;
	private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString(){
		return this.getId() + " - " + this.getNome();
		
	}

}
