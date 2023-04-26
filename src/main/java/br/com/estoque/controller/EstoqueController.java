package br.com.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.estoque.model.DTO.DetalharProdutoDTO;
import br.com.estoque.model.DTO.ProdutoDTO;
import br.com.estoque.service.ProdutoService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	@Autowired
	private ProdutoService serv;
	
	@PostMapping("/cad")
	@Transactional
	public ResponseEntity<DetalharProdutoDTO> adicionarNoEstoque(@RequestBody ProdutoDTO dto, UriComponentsBuilder uri) {
		var prod = serv.adicionarItem(dto);	
		
		return ResponseEntity.created(uri.path("/estoque").buildAndExpand(prod.getId()).toUri()).body(new DetalharProdutoDTO(prod));
	}
}
