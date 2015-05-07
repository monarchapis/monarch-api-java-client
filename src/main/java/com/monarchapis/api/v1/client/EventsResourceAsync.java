package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.EventDescriptor;
import com.monarchapis.api.v1.model.EventsResponse;
import com.monarchapis.api.v1.model.ObjectData;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.VoidCallback;

public interface EventsResourceAsync {

	public Future<EventDescriptor> getEventDescriptor(String eventType, Callback<EventDescriptor> callback);

	public void collectEvent(String eventType, ObjectData body, VoidCallback callback);

	public Future<EventsResponse> queryEvents(String eventType, String start, String end, String query,
			Callback<EventsResponse> callback);
}