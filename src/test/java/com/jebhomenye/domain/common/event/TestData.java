package com.jebhomenye.domain.common.event;

import lombok.EqualsAndHashCode;

public class TestData {
	
	static final TestEvent TEST_EVENT = new TestEvent();
	static final TestEvent2 TEST_EVENT2 = new TestEvent2();
	public static final TestEventSubClass TEST_EVENT_SUB = new TestEventSubClass();
	final TestEventSubscriber subscriber1 = new TestEventSubscriber();
	final TestEventSubscriber subscriber2 = new TestEventSubscriber();
	final TestEventSubscriber subscriber3 = new TestEventSubscriber();
	final TestEventSubscriber2 subscriber4 = new TestEventSubscriber2();
	
	public TestData(){
		
	}

	
	@EqualsAndHashCode(callSuper=true)
	static class TestEvent extends DomainEvent{
		private String value;
		
		public TestEvent(){
			value = "Test Event fired";
		}

		@Override
		public boolean sameValuesAs(DomainEvent other) {
			return this.equals(other);
		}
	}
	
	@EqualsAndHashCode(callSuper=true)
	static class TestEvent2 extends DomainEvent{
		private String value;
		
		public TestEvent2(){
			value = "Test Event 2 fired";
		}

		@Override
		public boolean sameValuesAs(DomainEvent other) {
			return this.equals(other);
		}
	}
	
	@EqualsAndHashCode(callSuper=true)
	static class TestEventSubClass extends TestEvent{
		private String value;
		
		public TestEventSubClass(){
			value = "Test Event subclass fired";
		}
	}
	
	static class TestEventSubscriber implements DomainEventSubscriber<TestEvent>{
		private DomainEvent event;

		@Override
		public void handleEvent(TestEvent domainEvent) {
			event = domainEvent;
			
		}

		@Override
		public Class<TestEvent> subscribedToEventType() {
			return TestEvent.class;
		}
		
		public DomainEvent event(){
			return event;
		}
		
		public void reset(){
			event = null;
		}
		
	}
	
	static class TestEventSubscriber2 implements DomainEventSubscriber<TestEvent2>{
		private DomainEvent event;
		
		@Override
		public void handleEvent(TestEvent2 domainEvent) {
			event = domainEvent;
			
		}
		
		@Override
		public Class<TestEvent2> subscribedToEventType() {
			return TestEvent2.class;
		}
		
		public DomainEvent event(){
			return event;
		}
		
		public void reset(){
			event = null;
		}
		
	}
}
