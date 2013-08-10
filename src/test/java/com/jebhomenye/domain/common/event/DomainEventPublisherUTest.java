package com.jebhomenye.domain.common.event;

import static org.junit.Assert.*;

import java.util.Arrays;


import org.junit.Before;
import org.junit.Test;

import com.jebhomenye.domain.common.event.TestData.TestEventSubscriber;
import com.jebhomenye.domain.common.event.TestData.TestEventSubscriber2;

public class DomainEventPublisherUTest {
	
	private DomainEventPublisher publisher;
	private TestData testData;
	
	@Before
	public void setup(){
		publisher = DomainEventPublisher.instance();
		publisher.reset();
		testData = new TestData();
	}

	@Test
	public void testPublishEventHandled() {
		TestEventSubscriber subscriber1 = testData.subscriber1;
		TestEventSubscriber subscriber2 = testData.subscriber2;
		TestEventSubscriber subscriber3 = testData.subscriber3;
		TestEventSubscriber2 subscriber4 = testData.subscriber4;
				
		publisher.subscribe(subscriber1);
		publisher.subscribe(subscriber2);
		publisher.subscribe(subscriber3);
		publisher.subscribe(subscriber4);
		
		assertEquals(4, publisher.subscribers().size());
		
		publisher.publish(TestData.TEST_EVENT);
				
		DomainEvent expected = TestData.TEST_EVENT;
		
		assertEquals(expected, subscriber1.event());
		assertEquals(expected, subscriber2.event());
		assertEquals(expected, subscriber3.event());
		assertNull(subscriber4.event());
		
		subscriber1.reset();
		subscriber2.reset();
		subscriber3.reset();
		subscriber4.reset();
		
		publisher.publish(TestData.TEST_EVENT2);
		
		expected = TestData.TEST_EVENT2;
		assertEquals(expected, subscriber4.event());
		assertNull(subscriber1.event());
		assertNull(subscriber2.event());
		assertNull(subscriber3.event());
		
		
	}
	
	@Test
	public void testSubClassEventHandledBySuperClassSubscribers(){
		TestEventSubscriber subscriber1 = testData.subscriber1;
		TestEventSubscriber subscriber2 = testData.subscriber2;
		
		publisher.subscribe(Arrays.asList(subscriber1, subscriber2));
		
		publisher.publish(TestData.TEST_EVENT_SUB);
		
		DomainEvent expected = TestData.TEST_EVENT_SUB;
		
		assertEquals(expected, subscriber1.event());
		assertEquals(expected, subscriber2.event());
		
	}
	
	

}
