package com.jebhomenye.domain.common.core;

import java.io.Serializable;

public interface Identity<T extends Serializable> {
	
	T id();
}
