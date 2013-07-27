package com.jebhomenye.domain.common.core;

public abstract class AbstractValueObject<V> implements ValueObject<V> {

	public boolean sameValuesAs(V other) {
		return this.equals(other);
	}
}
