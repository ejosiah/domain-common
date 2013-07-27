package com.jebhomenye.domain.common.id;

import java.io.Serializable;


public interface IdGenerator<ID extends Serializable> {
	
	ID nextId();
}
