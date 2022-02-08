package com.bookstore.resources.dtos;

import java.io.Serializable;

import com.bookstore.domain.Livro;

public class LivroDTO implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -7290467318674762139L;

	private Integer id;

	private String titulo;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
