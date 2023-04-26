package br.com.estoque.model.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
		@NotBlank 
		String tipo,
		@NotBlank 
		String nome,
		@NotBlank 
		String descricao,
		@NotNull 
		@JsonFormat(pattern = "dd/MM/yyyy") 
		LocalDate data
		) {

}
