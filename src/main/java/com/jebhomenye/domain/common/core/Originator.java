package com.jebhomenye.domain.common.core;

public interface Originator<T extends Momento> {
	
	T takeSnapShot();
	
	void restoreFrom(T momento);
	
}
