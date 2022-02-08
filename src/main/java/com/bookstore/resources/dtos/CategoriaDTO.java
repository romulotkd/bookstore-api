package com.bookstore.resources.dtos;

import java.io.Serializable;

import com.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable{

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -7276421202576360070L;

	private Integer id;

	private String nome;

	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
