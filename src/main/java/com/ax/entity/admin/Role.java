package com.ax.entity.admin;

/**
 * Classe que contem o nivel de acesso da Classe User
 * 
 * @author Aliomar Junior
 *
 */
public class Role {

	private Long id;
	private String descricao;
	private String nivel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString(){
		return this.id +" - " + this.descricao;
	}
}
