package br.com.estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import br.com.estoque.model.Produto;
import br.com.estoque.service.util.repository.ProdutoRepository;

@Service
public class RelatorioService {
	@Autowired
	private ProdutoRepository repo;

	public Page<Produto> listar(){
		return new PageImpl<>(repo.findAll());
	}

}
