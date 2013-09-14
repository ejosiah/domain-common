package com.jebhomenye.domain.common.event;

import java.io.Serializable;

import org.joda.time.DateTime;

public interface Event extends Serializable {
	
	DateTime occuredOn();
	
	int version();
}
