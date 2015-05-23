package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.LogEntry;
import com.monarchapis.api.v1.model.LogEntryList;
import com.monarchapis.api.v1.model.LogEntryUpdate;
import com.monarchapis.client.rest.Callback;

public interface LogEntriesResourceAsync {

	public Future<LogEntryList> query(LogEntriesQuery query, Callback<LogEntryList> callback);

	public Future<LogEntry> create(LogEntryUpdate body, Callback<LogEntry> callback);

	public Future<LogEntry> load(String id, Callback<LogEntry> callback);

	public Future<LogEntry> update(String id, LogEntryUpdate body, Callback<LogEntry> callback);

	public Future<LogEntry> delete(String id, Callback<LogEntry> callback);
}