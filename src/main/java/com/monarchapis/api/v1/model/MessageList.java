package com.monarchapis.api.v1.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MessageList {

	@NotNull
	private List<MessageDetails> messages;

	public List<MessageDetails> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageDetails> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
