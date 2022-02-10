package com.bookstore.resources.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.bookstore.domain.Livro;

public class LivroDTO implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -7290467318674762139L;

	private Integer id;

	@NotEmpty(message = "Campo TITULO é requerido.")
	@Length(min = 3, max = 50, message = "Campo TITULO deve ter entre 3 e 50 caracteres.")
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
