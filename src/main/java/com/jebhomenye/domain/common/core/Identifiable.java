package com.jebhomenye.domain.common.core;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> {
	
	T id();
}
