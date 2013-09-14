package com.jebhomenye.domain.common.core;

import static com.jebhomenye.domain.common.util.DynamicMethodInvoker.invoke;

import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

import lombok.SneakyThrows;

import com.jebhomenye.domain.common.event.DomainEvent;
import com.jebhomenye.domain.common.event.DomainEventPublisher;
import com.jebhomenye.domain.common.event.Event;

/**
 * A collection of objects that are bound together by a root entity, otherwise known as an aggregate root. 
 * The aggregate root guarantees the consistency of changes being made within the aggregate by forbidding 
 * external objects from holding references to its members
 * @author jay
 *
 * @param <E> Type of root entity
 * @param <T> Type of root entity's identity
 * @param <M> Type of Momento object for this aggregate root
 */
public abstract class AggregateRoot<E, T extends Identity<? extends Serializable>, M extends Momento> 
		implements ConcurrentModificationSafeEntity<E, T>, Originator<M> {
	
	private LinkedList<Event> changes = new LinkedList<>();
		
	public <D extends DomainEvent>void apply(D event){
		changes.add(event);
		mutate(event);
	}

	@Override
	public void failOnConcurrentModification(int aVersion)
			throws ConcurrentModificationException {
		if(this.version() != aVersion){
			throw new ConcurrentModificationException();
		}
		
	}
	
	/**
	 * mutates the aggregate root with the contents of the event.
	 * The aggregate root should have a matching when method that
	 * takes the event as its parameter
	 * @param event event to apply to the aggregate root.
	 */
	@SneakyThrows
	public <D extends Event>void mutate(D event){
		invoke("when", this, event);
	}
	
	public void replayEvents(List<Event> events){
		for(Event event : events){
			mutate(event);
		}
	}

	@Override
	public M takeSnapShot() {
		throw new UnsupportedOperationException("should be implemented by subclass that requre");
	}

	@Override
	public void restoreFrom(M momento) {
		throw new UnsupportedOperationException("should be implemented by subclass that requre");
	}
	
	public LinkedList<Event> changes(){
		return changes;
	}
}
