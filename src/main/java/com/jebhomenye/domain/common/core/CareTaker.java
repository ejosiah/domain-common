package com.jebhomenye.domain.common.core;

import java.io.Serializable;

public interface CareTaker {
	
	<T extends Momento, ID extends Serializable> T getMomentoById(Identity<ID> id);
	
	<T extends Momento, ID extends Serializable> void saveMomento(Momento momento);
}
