package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="jogos")
public class JogosModel {

	//definindo atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String descricao;
	
	@ManyToOne   //relacao muitos para um
	@JsonIgnoreProperties("jogo")
	private CategoriaModel categoria;

	//getters and setters
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
	
}