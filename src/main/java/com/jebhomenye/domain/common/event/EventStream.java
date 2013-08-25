package com.jebhomenye.domain.common.event;

import java.util.LinkedList;

public class EventStream {
	
	public int version;
	
	public LinkedList<DomainEvent> events = new LinkedList<>();
}
