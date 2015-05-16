package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Message;
import com.monarchapis.api.v1.model.MessageList;
import com.monarchapis.api.v1.model.MessageUpdate;
import com.monarchapis.client.rest.Callback;

public interface MessagesResourceAsync {

	public Future<MessageList> queryMessages(MessagesQuery query, Callback<MessageList> callback);

	public Future<Message> createMessage(MessageUpdate body, Callback<Message> callback);

	public Future<Message> loadMessage(String id, Callback<Message> callback);

	public Future<Message> updateMessage(String id, MessageUpdate body, Callback<Message> callback);

	public Future<Message> deleteMessage(String id, Callback<Message> callback);
}