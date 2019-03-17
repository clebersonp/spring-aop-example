package br.com.cpp.aop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.cpp.aop.auditable.Auditable;
import br.com.cpp.aop.model.FormaPagamento;
import br.com.cpp.aop.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {
	
	private FormaPagamentoRepository repository;
	
	@Autowired
	public FormaPagamentoService(FormaPagamentoRepository repository) {
		this.repository = repository;
	}
	
	@Auditable(value = { "Service de listar formas de pagamento no micro service spring-aop-example" })
	@Cacheable(cacheNames = { "spring-aop-caching" })
	public Collection<FormaPagamento> listar() {
		return this.repository.findAllByOrderByDescricaoAsc();
	}
	
	@CacheEvict(cacheNames = { "spring-aop-caching" }, allEntries = true)
	public FormaPagamento buscarPorId(final Short id) {
		return this.repository.findById(id).orElse(null);
	}
}