package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.LogEntry;
import com.monarchapis.api.v1.model.LogEntryList;
import com.monarchapis.api.v1.model.LogEntryUpdate;

public interface LogEntriesResource {

	public LogEntryList queryLogEntries(LogEntriesQuery query);

	public LogEntry createLogEntry(LogEntryUpdate body);

	public LogEntry loadLogEntry(String id);

	public LogEntry updateLogEntry(String id, LogEntryUpdate body);

	public LogEntry deleteLogEntry(String id);
}