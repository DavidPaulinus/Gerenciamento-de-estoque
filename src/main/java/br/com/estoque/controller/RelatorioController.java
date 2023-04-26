package br.com.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estoque.model.DTO.EstoqueDTO;
import br.com.estoque.model.DTO.VendasDTO;
import br.com.estoque.service.RelatorioService;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {
	@Autowired
	private RelatorioService serv;
	
	@GetMapping("/vendas")
	public ResponseEntity<Page<VendasDTO>> relatorioDeVendas() {
		return ResponseEntity.ok(serv.listar().map(VendasDTO::new));
	}
	
	@GetMapping("/estoque")
	public ResponseEntity<Page<EstoqueDTO>> relatorioEstoque() {
		return ResponseEntity.ok(serv.listar().map(EstoqueDTO::new));
	}
}
