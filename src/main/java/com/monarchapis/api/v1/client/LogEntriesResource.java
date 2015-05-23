package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.LogEntry;
import com.monarchapis.api.v1.model.LogEntryList;
import com.monarchapis.api.v1.model.LogEntryUpdate;

public interface LogEntriesResource {

	public LogEntryList query(LogEntriesQuery query);

	public LogEntry create(LogEntryUpdate body);

	public LogEntry load(String id);

	public LogEntry update(String id, LogEntryUpdate body);

	public LogEntry delete(String id);
}