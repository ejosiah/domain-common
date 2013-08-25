package com.jebhomenye.domain.common.core;

import java.io.Serializable;


public interface Entity<T extends Identity<? extends Serializable>> extends Identifiable<T> {
	
	boolean sameIdentityAs(Entity<T> other);
}
