package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.LogEntry;
import com.monarchapis.api.v1.model.LogEntryList;
import com.monarchapis.api.v1.model.LogEntryUpdate;
import com.monarchapis.client.rest.Callback;

public interface LogEntriesResourceAsync {

	public Future<LogEntryList> queryLogEntries(LogEntriesQuery query, Callback<LogEntryList> callback);

	public Future<LogEntry> createLogEntry(LogEntryUpdate body, Callback<LogEntry> callback);

	public Future<LogEntry> loadLogEntry(String id, Callback<LogEntry> callback);

	public Future<LogEntry> updateLogEntry(String id, LogEntryUpdate body, Callback<LogEntry> callback);

	public Future<LogEntry> deleteLogEntry(String id, Callback<LogEntry> callback);
}