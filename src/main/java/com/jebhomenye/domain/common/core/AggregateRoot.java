package com.jebhomenye.domain.common.core;

import static com.jebhomenye.domain.common.util.DynamicMethodInvoker.invoke;

import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

import lombok.SneakyThrows;

import com.jebhomenye.domain.common.event.DomainEvent;

public abstract class AggregateRoot<T extends Identity<? extends Serializable>, M extends Momento> 
		implements ConcurrentModificationSafeEntity<T>, Originator<M> {
	
	private static final LinkedList<DomainEvent> changes = new LinkedList<>();
	
	public <D extends DomainEvent>void apply(D event){
		changes.add(event);
		mutate(event);
	}

	@Override
	public void restoreFrom(M momento) {
		
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
	public <D extends DomainEvent>void mutate(D event){
		invoke("when", this, event);
	}
	
	public void replayEvents(List<DomainEvent> events){
		for(DomainEvent event : events){
			mutate(event);
		}
	}

}
