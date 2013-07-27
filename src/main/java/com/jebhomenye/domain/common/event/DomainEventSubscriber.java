package com.jebhomenye.domain.common.event;

public interface DomainEventSubscriber<T extends DomainEvent> {

    public void handleEvent(final T domainEvent);

    public Class<T> subscribedToEventType();
}
