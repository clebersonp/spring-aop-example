package br.com.cpp.aop.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cpp.aop.model.FormaPagamento;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Short> {
	Collection<FormaPagamento> findAllByOrderByDescricaoAsc();
}