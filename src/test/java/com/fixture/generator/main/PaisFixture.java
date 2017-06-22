package com.fixture.generator.main;

import com.fixture.generator.main.Pais;
import java.util.List;
import java.util.ArrayList;
public class PaisFixture {

	private Pais pais = new Pais();

	public static PaisFixture get() {
		return new PaisFixture();
	}

	public Pais build() {
		return pais;
	}

	public List<Pais> buildList(Integer amount) {
		List<Pais> paiss = new ArrayList<Pais>();
		for (int i = 0; i < amount; i++) {
			paiss.add(this.build());
		}
		return paiss;
	}

	public PaisFixture comId(Long id) {
		this.pais.setId(id);
		return this;
	}

	public PaisFixture comSigla(String sigla) {
		this.pais.setSigla(sigla);
		return this;
	}

	public PaisFixture comNome(String nome) {
		this.pais.setNome(nome);
		return this;
	}
}