package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.EventDescriptor;
import com.monarchapis.api.v1.model.EventsResponse;
import com.monarchapis.api.v1.model.ObjectData;

public interface EventsResource {

	public EventDescriptor getEventDescriptor(String eventType);

	public void collectEvent(String eventType, ObjectData body);

	public EventsResponse queryEvents(String eventType, String start, String end, String query);
}