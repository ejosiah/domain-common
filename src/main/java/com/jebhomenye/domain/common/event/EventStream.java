package com.jebhomenye.domain.common.event;

import java.util.LinkedList;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent=true)
public class EventStream {
	
	private int version;
	private Class<? extends Event> eventType;
	private List<Event> events = new LinkedList<>();

}
 