package com.jebhomenye.domain.common.core;

import java.io.Serializable;
import java.util.ConcurrentModificationException;

public interface ConcurrentModificationSafeEntity<T extends Identity<? extends Serializable>> extends Entity<T>{
	
	void version(int version);
	
	int version();
	
	void failOnConcurrentModification(int aVersion) throws ConcurrentModificationException;
}
