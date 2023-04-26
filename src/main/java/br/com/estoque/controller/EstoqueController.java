package br.com.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public ResponseEntity<Page<DetalharProdutoDTO>> listarProdutos(){
		return ResponseEntity.ok(serv.listarProdutos().map(DetalharProdutoDTO::new));
	}
	
	@PutMapping("/edit/{id}")
	@Transactional
	public ResponseEntity<DetalharProdutoDTO> editarProduto(@PathVariable Long id, @RequestBody ProdutoDTO dto){
		var prod = serv.editar(id, dto);
		
		return ResponseEntity.ok(new DetalharProdutoDTO(prod));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Page<DetalharProdutoDTO>> excluirProduto(@PathVariable Long id){
		return ResponseEntity.ok(serv.excluir(id).map(DetalharProdutoDTO::new));
	}
}
