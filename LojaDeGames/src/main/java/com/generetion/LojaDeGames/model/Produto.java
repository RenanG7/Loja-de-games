package com.generetion.LojaDeGames.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo nome é Obrigatorio!")
	@Size(min = 5, max = 100, message = "O atributo nome deve conter entre 05 e no maximo 100 catactere")
	private String nome;

	@NotNull(message = "O atributo valor é Obrigatorio!")
	@DecimalMin(value = "5.00", message = "O preço do produto precisa ser um valor positivo e acima de R$ 5,00 ")
	private BigDecimal valor;

	@NotBlank(message = "A descrição é Obrigatorio!")
	@Size(min = 5, max = 1000, message = "A descriçao deve conter entre 10 e no maximo 1000 catactere")
	private String decricao;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	@ManyToOne
	@JsonIgnoreProperties("Produto")
	private Categoria categoria;

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDecricao() {
		return decricao;
	}

	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
