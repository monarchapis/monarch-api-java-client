package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.ObjectData;
import com.monarchapis.client.rest.Callback;

public interface CommandsResourceAsync {

	public Future<ObjectData> processCommand(String commandType, ObjectData body, Callback<ObjectData> callback);
}