package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Message;
import com.monarchapis.api.v1.model.MessageList;
import com.monarchapis.api.v1.model.MessageUpdate;
import com.monarchapis.client.rest.Callback;

public interface MessagesResourceAsync {

	public Future<MessageList> query(MessagesQuery query, Callback<MessageList> callback);

	public Future<Message> create(MessageUpdate body, Callback<Message> callback);

	public Future<Message> load(String id, Callback<Message> callback);

	public Future<Message> update(String id, MessageUpdate body, Callback<Message> callback);

	public Future<Message> delete(String id, Callback<Message> callback);
}