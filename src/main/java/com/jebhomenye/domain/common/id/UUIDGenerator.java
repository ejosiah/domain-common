package com.jebhomenye.domain.common.id;

import java.util.UUID;

public class UUIDGenerator implements IdGenerator<String> {

	public String nextId() {
		return UUID.randomUUID().toString().toUpperCase();
	}

}
