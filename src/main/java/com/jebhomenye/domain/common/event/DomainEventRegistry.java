package com.jebhomenye.domain.common.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Named;

@Named
public class DomainEventRegistry {
	private final Map<Class<? extends DomainEvent>, List<DomainEventSubscriber<? extends DomainEvent>>> registry = new ConcurrentHashMap<>();
	
	public void registerForDomainEvent(Class<? extends DomainEvent> eventType, DomainEventSubscriber<? extends DomainEvent> subscriber){
		if(registry.containsKey(eventType)){
			registry.get(eventType).add(subscriber);
		}else{
			List<DomainEventSubscriber<? extends DomainEvent>> subscribers = new ArrayList<>();
			subscribers.add(subscriber);
			registry.put(eventType, subscribers);
		}
	}
	
	public List<DomainEventSubscriber<? extends DomainEvent>> subscribersForDomainEvent(Class<? extends DomainEvent> eventType){
		return registry.get(eventType);
	}
}
