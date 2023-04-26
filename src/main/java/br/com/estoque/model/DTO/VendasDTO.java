package br.com.estoque.model.DTO;

import br.com.estoque.model.Produto;

public record VendasDTO(String nome, Integer vendido) {
	public VendasDTO(Produto prod) {
		this(prod.getNome(), prod.getVendido());
	}
}
