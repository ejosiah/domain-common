package com.jebhomenye.domain.common.id;

import java.util.concurrent.atomic.AtomicLong;

public class SequencialIdGenerator implements IdGenerator<Long> {
	
	private final AtomicLong generator = new AtomicLong(0);

	public Long nextId() {
		return generator.incrementAndGet();
	}
	
	public void reset(){
		generator.set(0);
	}	
}
