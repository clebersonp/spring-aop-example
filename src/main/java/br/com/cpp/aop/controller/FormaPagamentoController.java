package br.com.cpp.aop.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cpp.aop.model.FormaPagamento;
import br.com.cpp.aop.service.FormaPagamentoService;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {

	private FormaPagamentoService service;

	public FormaPagamentoController(FormaPagamentoService service) {
		this.service = service;
	}

	@GetMapping
	public Collection<FormaPagamento> listar() {
		return this.service.listar();
	}

	@GetMapping("/{id}")
	public FormaPagamento buscarPorId(@PathVariable Short id) {
		return this.service.buscarPorId(id);
	}
}
