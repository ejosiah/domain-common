package com.jebhomenye.domain.common.core;

import java.io.Serializable;

public interface IdentifiableValueObject<V, T extends Serializable> extends ValueObject<V>, Identifiable<T> {

}
