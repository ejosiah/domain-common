package com.jebhomenye.domain.common.core;

public interface ValueObject<V> {
	
	boolean sameValuesAs(V other);
}
