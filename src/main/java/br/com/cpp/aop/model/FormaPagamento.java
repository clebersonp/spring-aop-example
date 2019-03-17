package br.com.cpp.aop.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author cleberson
 *
 */
@Entity
@Table(name = "forma_pagamento", catalog = "spring_boot_examples")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class FormaPagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Short id;
	
	@Column(name = "descricao", nullable = false, length = 50)
	private String descricao;

	@Column(name = "usuario", nullable = false, length = 50)
	private String usuario;
	
	@Column(name = "dhr_inclusao", nullable = false, length = 26)
	@CreationTimestamp
	private LocalDateTime dataHoraInclusao;

	@Column(name = "dhr_alteracao", nullable = false, length = 26)
	@UpdateTimestamp
	private LocalDateTime dataHoraAlteracao;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}