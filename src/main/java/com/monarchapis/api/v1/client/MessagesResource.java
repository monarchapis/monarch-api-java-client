package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Message;
import com.monarchapis.api.v1.model.MessageList;
import com.monarchapis.api.v1.model.MessageUpdate;

public interface MessagesResource {

	public MessageList queryMessages(MessagesQuery query);

	public Message createMessage(MessageUpdate body);

	public Message loadMessage(String id);

	public Message updateMessage(String id, MessageUpdate body);

	public Message deleteMessage(String id);
}