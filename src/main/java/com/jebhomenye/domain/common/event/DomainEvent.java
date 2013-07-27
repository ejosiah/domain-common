package com.jebhomenye.domain.common.event;

import org.joda.time.DateTime;

import com.jebhomenye.domain.common.core.ValueObject;

public abstract class DomainEvent implements ValueObject<DomainEvent>{
	
	protected final DateTime occuredOn;
	
	public DomainEvent(){
		occuredOn = DateTime.now();
	}
	
	public DateTime occuredOn(){
		return occuredOn;
	}
}
