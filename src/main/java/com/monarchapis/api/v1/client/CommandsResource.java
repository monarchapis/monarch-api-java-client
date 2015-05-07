package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.ObjectData;

public interface CommandsResource {

	public ObjectData processCommand(String commandType, ObjectData body);
}