package br.com.estoque.service.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estoque.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
