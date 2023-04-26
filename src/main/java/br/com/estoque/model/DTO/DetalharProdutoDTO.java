package br.com.estoque.model.DTO;

import java.time.LocalDate;

import br.com.estoque.model.Produto;

public record DetalharProdutoDTO(Long id, String tipo, String nome, String descricao, LocalDate data) {
	public DetalharProdutoDTO(Produto prod) {
		this(prod.getId(), prod.getTipo(), prod.getNome(), prod.getDescricao(), prod.getData());
	}
}
