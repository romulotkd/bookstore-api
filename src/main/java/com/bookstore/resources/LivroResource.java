package com.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookstore.domain.Livro;
import com.bookstore.resources.dtos.LivroDTO;
import com.bookstore.service.LivroService;

@CrossOrigin("*") // Para receber chamadas de várias fontes diferentes.
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	/*
	 * Vamos pegar todos os livros de uma categoria.
	 */
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAllByCategoria(
			@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
		List<Livro> lista = service.findAll(id_cat);
		List<LivroDTO> listDTO = lista.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> update(@PathVariable Integer id, @RequestBody Livro obj) {
		Livro newObj = service.update(id, obj);
		return ResponseEntity.ok().body(new LivroDTO(newObj));
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> updatePatch(@PathVariable Integer id, @Valid @RequestBody Livro obj) {
		Livro newObj = service.update(id, obj);
		return ResponseEntity.ok().body(new LivroDTO(newObj));
	}

	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
			@Valid @RequestBody Livro obj) {
		obj = service.create(id_cat, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).body(obj);
		return ResponseEntity.created(uri).build(); // Sem passar o objeto criado, só o uri. Que fica em headers >
													// location.
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
