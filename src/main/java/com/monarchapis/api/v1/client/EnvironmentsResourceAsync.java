package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Environment;
import com.monarchapis.api.v1.model.EnvironmentList;
import com.monarchapis.api.v1.model.EnvironmentSummary;
import com.monarchapis.api.v1.model.EnvironmentUpdate;
import com.monarchapis.client.rest.Callback;

public interface EnvironmentsResourceAsync {

	public Future<EnvironmentList> query(EnvironmentsQuery query, Callback<EnvironmentList> callback);

	public Future<Environment> create(EnvironmentUpdate body, Callback<Environment> callback);

	public Future<Environment> load(String id, Callback<Environment> callback);

	public Future<Environment> update(String id, EnvironmentUpdate body, Callback<Environment> callback);

	public Future<Environment> delete(String id, Callback<Environment> callback);

	public Future<EnvironmentSummary> getSummary(Callback<EnvironmentSummary> callback);
}