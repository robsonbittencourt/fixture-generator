package com.fixture.generator.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PaisMapper implements Mapper<PaisType, Pais> {

	public PaisType toType(Pais entity) {
		if (entity == null) {
			return null;
		}
		PaisType paisType = new PaisType();
		paisType.setId(entity.getId());
		paisType.setNome(entity.getNome());
		paisType.setSigla(entity.getSigla());
		return paisType;
	}

	public Pais toEntity(PaisType type) {
		if (type == null) {
			return null;
		}
		Pais pais = new Pais();
		pais.setId(type.getId());
		pais.setNome(type.getNome());
		pais.setSigla(type.getSigla());
		return pais;
	}

	public List<PaisType> toTypeList(Collection<Pais> entityList) {
		List<PaisType> paisesType = new ArrayList<>();
		for (Pais pais : entityList) {
			paisesType.add(toType(pais));
		}
		return paisesType;
	}

	public List<Pais> toEntityList(Collection<PaisType> typeList) {
		List<Pais> listEntity = new ArrayList<>();
		for (PaisType type : typeList) {
			listEntity.add(toEntity(type));
		}
		return listEntity;
	}

}
