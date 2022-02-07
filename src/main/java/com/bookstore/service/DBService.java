package com.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.domain.Livro;
import com.bookstore.repositories.CategoriaRepository;
import com.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Matemática", "Livro de Matemática");
		Categoria cat3 = new Categoria(null, "Medicina", "Livro de Medicina");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Qualquer coisa pra escrever", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Qualquer coisa pra escrever", cat1);
		Livro l3 = new Livro(null, "Livro de Matemática 1", "Autor 1", "Qualquer coisa pra escrever", cat2);
		Livro l4 = new Livro(null, "Livro de Matemática 2", "Autor 2", "Qualquer coisa pra escrever", cat2);
		Livro l5 = new Livro(null, "Livro de Matemática 3", "Autor 3", "Qualquer coisa pra escrever", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
