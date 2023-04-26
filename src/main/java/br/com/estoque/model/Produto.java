package br.com.estoque.model;

import java.time.LocalDate;

import br.com.estoque.model.DTO.ProdutoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_produto")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private String nome;
	private String descricao;
	private LocalDate data;

	public Produto(ProdutoDTO dto) {
		this.tipo = dto.tipo();
		this.nome = dto.nome();
		this.descricao = dto.descricao();
		this.data = dto.data();
	}

	public void atualizar(ProdutoDTO dto) {
		this.tipo = dto.tipo();
		this.nome = dto.nome();
		this.descricao = dto.descricao();
		this.data = dto.data();
	}
}
