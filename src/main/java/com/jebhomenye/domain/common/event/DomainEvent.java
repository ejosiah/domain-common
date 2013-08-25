package com.jebhomenye.domain.common.event;

import org.joda.time.DateTime;

import com.jebhomenye.domain.common.core.ValueObject;

public abstract class DomainEvent implements Event, ValueObject<DomainEvent>{
	
	private static final long serialVersionUID = 1L;
	
	protected final DateTime occuredOn;
	
	{
		occuredOn = DateTime.now();
	}

	public DateTime occuredOn(){
		return occuredOn;
	}
}
