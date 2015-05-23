package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Message;
import com.monarchapis.api.v1.model.MessageList;
import com.monarchapis.api.v1.model.MessageUpdate;

public interface MessagesResource {

	public MessageList query(MessagesQuery query);

	public Message create(MessageUpdate body);

	public Message load(String id);

	public Message update(String id, MessageUpdate body);

	public Message delete(String id);
}