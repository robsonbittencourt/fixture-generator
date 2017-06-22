package com.fixture.generator.main;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paisType", propOrder = { "id", "sigla", "nome" })
public class PaisType implements Serializable {

	protected Long id;
	@XmlElement(required = true)
	protected String sigla;
	@XmlElement(required = true)
	protected String nome;

	/**
	 * Obtém o valor da propriedade id.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Define o valor da propriedade id.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setId(Long value) {
		this.id = value;
	}

	/**
	 * Obtém o valor da propriedade sigla.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * Define o valor da propriedade sigla.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSigla(String value) {
		this.sigla = value;
	}

	/**
	 * Obtém o valor da propriedade nome.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o valor da propriedade nome.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNome(String value) {
		this.nome = value;
	}

}
