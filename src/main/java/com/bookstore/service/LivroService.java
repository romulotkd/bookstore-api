package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.domain.Livro;
import com.bookstore.repositories.LivroRepository;
import com.bookstore.service.exception.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(final Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro create(final Livro obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
	}

	public void delete(Integer id) {
		try {
			Livro livro = findById(id);
			repository.delete(livro);
		} catch (DataIntegrityViolationException e) {
			throw new com.bookstore.service.exception.DataIntegrityViolationException("Livro não pode ser deletado!");
		}
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria categoria = categoriaService.findById(id_cat);
		obj.setCategoria(categoria);
		return repository.save(obj);
	}
}
