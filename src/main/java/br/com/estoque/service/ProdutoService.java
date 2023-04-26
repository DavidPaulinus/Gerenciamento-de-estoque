package br.com.estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import br.com.estoque.model.Produto;
import br.com.estoque.model.DTO.ProdutoDTO;
import br.com.estoque.service.util.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;

	public Produto adicionarItem(ProdutoDTO dto) {
		var prod = new Produto(dto);
		repo.save(prod);
		
		return prod;
	}

	public Page<Produto> listarProdutos() {
		return new PageImpl<>(repo.findAll());
	}

	public Produto editar(Long id, ProdutoDTO dto) {
		var prod = repo.findById(id).orElseThrow(() -> new RuntimeException("Id inválido. Produto não encontrado."));
		prod.atualizar(dto);
		
		return prod;
	}

	public Page<Produto> excluir(Long id) {
		repo.deleteById(id);
		
		return listarProdutos();
	}
}
