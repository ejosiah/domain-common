package com.jebhomenye.domain.common.core;

import java.io.Serializable;


public interface Entity<E, T extends Identity<? extends Serializable>> extends Identifiable<T> {
	
	boolean sameIdentityAs(E other);
}
