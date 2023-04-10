package br.com.magna.confeccao.infra;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.magna.confeccao.domain.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Void> tratarErro404() {
		return ResponseEntity.notFound().build();

	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<DadosErroValidacao> handleException(HttpMessageNotReadableException ex) {
		String[] erroMensagem = ex.getMessage().split("from");
		String erroTipo = erroMensagem[1];

		String[] erroCausa = ex.getCause().toString().split("; ", 20);
		String[] erroSepararLinha = erroCausa[1].split(",");
		String linhaErro = erroSepararLinha[0];
		String erro = linhaErro.concat(erroTipo);

		return ResponseEntity.badRequest()
				.body(new DadosErroValidacao(erro, "Tipo de valor inserido é inválido para o campo"));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<DadosErroValidacao>> tratarErro400(MethodArgumentNotValidException ex) {
		List<FieldError> erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DadosErroValidacao> tratarErro500(DataIntegrityViolationException ex) {
		new DadosErroValidacao(ex.getCause().toString(), ex.getMessage());

		return ResponseEntity.internalServerError()
				.body(new DadosErroValidacao(ex.getCause().toString(), ex.getMessage()));
	}

	@ExceptionHandler(ValidacaoException.class)
	public ResponseEntity<String> tratarErroRegraDeNegocio(ValidacaoException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

}
