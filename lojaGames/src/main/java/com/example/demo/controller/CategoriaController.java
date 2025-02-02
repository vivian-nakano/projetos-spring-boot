package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.example.demo.model.CategoriaModel;
import com.example.demo.repository.CategoriaRepository;

@RestController
@CrossOrigin("*")
public class CategoriaController implements WebMvcConfigurer{

	@Autowired
	private CategoriaRepository repository;
	
	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}
	
	@GetMapping("/categoria")
	public List<CategoriaModel> findAllCategoria(){
		return repository.findAll();
	}
	
	@GetMapping("/categoria/{id}")
	public Optional<CategoriaModel> findByIdCategoria (@PathVariable Long id){
		return repository.findById(id);
	}
	
	@GetMapping("/categoria/descricao/{descricao}")
	public ResponseEntity<List<CategoriaModel>> findByDescricaoCategoria (@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping("/categoria")
	public ResponseEntity<CategoriaModel> post (@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping("/categoria/{id}")
	public CategoriaModel putCategoria (@PathVariable Long id, @RequestBody CategoriaModel objCategoria) {
		objCategoria.setId(id);
		repository.save(objCategoria);
		return objCategoria;
	}
	
	@DeleteMapping("/categoria/{id}")
	public void deleteCategoria(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}