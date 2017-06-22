package com.fixture.generator.main;

import java.util.Collection;
import java.util.List;

public interface Mapper<T, O> {

	T toType(O entity);

	O toEntity(T type);

	List<T> toTypeList(Collection<O> entityList);

	List<O> toEntityList(Collection<T> typeList);

}
