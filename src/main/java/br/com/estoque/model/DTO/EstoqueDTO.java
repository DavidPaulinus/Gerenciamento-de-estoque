package br.com.estoque.model.DTO;

import br.com.estoque.model.Produto;

public record EstoqueDTO(String nome, Integer estoque) {
	public EstoqueDTO(Produto prod) {
		this(prod.getNome(), prod.getEstoque());
	}
}
