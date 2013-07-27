package com.jebhomenye.domain.common.core;

import java.io.Serializable;
import java.util.ConcurrentModificationException;

public interface ConcurrentModificationSafeEntity<E, T extends Identity<? extends Serializable>> extends Entity<E, T>{
	
	void setVersion(int version);
	
	void version();
	
	void failOnConcurrentModification(int aVersion) throws ConcurrentModificationException;
}
