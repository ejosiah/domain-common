package com.jebhomenye.domain.common.event;

import java.util.Iterator;

public interface EventStream {
	
	int version();
	
	Iterator<Event> eventIterator();
}
 