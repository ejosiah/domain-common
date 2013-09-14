package com.jebhomenye.domain.common.event;

import java.io.Serializable;
import java.util.Collection;

import com.jebhomenye.domain.common.core.Identity;

public interface EventStore {
	
	EventStream loadBy(Identity<?extends Serializable> id);
	
	EventStream loadAfterVersion(int version, Identity<? extends Serializable> id);
	
	EventStream loadSubSet(Identity<? extends Serializable> id, int skipEvents, int maxCount);
	
	void appendToStream(Identity<? extends Serializable> id, int expectedVersion, Collection<Event> events);
}
