package com.jebhomenye.domain.common.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A light weight event publisher that publishes events 
 * to subscribers on the same thread
 * @author josiah.ebhomenye
 *
 */
public class DomainEventPublisher {
	
	private static ThreadLocal<DomainEventPublisher> instance = new ThreadLocal<DomainEventPublisher>();
	private @SuppressWarnings("rawtypes") List subscribers;
	
	private DomainEventPublisher(){
		ensureSureSubscriberList();
	}

	@SuppressWarnings("rawtypes")
	private void ensureSureSubscriberList() {
		if(subscribers == null){
			subscribers = new ArrayList();
		}
		
	}

	public static DomainEventPublisher instance() {
		if(instance.get() == null){
			instance.set(new DomainEventPublisher());
		}
		return instance.get();
	}

	@SuppressWarnings("unchecked")
	public <T extends DomainEvent> void subscribe(DomainEventSubscriber<T> subscriber) {
		ensureSureSubscriberList();
		subscribers.add(subscriber);
	}

	public <T extends DomainEvent> void publish(T event) {
		Class<?> eventType = event.getClass();
		
		@SuppressWarnings("unchecked")
		List<DomainEventSubscriber<T>> allSubscribers = subscribers;
		
		for(DomainEventSubscriber<T> subscriber : allSubscribers){
			
			Class<T> subscribedToEvent = subscriber.subscribedToEventType();
			
			if(subscribedToEvent == eventType || subscribedToEvent.isAssignableFrom(eventType)){
				subscriber.handleEvent(event);
			}
		}
		
	}
	
	public void reset(){
		if(subscribers != null){
			subscribers.clear();
		}
	}
	
	@SuppressWarnings("rawtypes")
	protected List subscribers(){
		return subscribers;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void subscribe(Collection subscribers) {
		this.subscribers.addAll(subscribers);
		
	}

}

