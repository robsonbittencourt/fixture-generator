package com.utility.generator.base.clazz;


public abstract class AbstractMapper<T, P> {

	abstract T toType(P p);

}
