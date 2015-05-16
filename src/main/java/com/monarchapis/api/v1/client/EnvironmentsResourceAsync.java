package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Environment;
import com.monarchapis.api.v1.model.EnvironmentList;
import com.monarchapis.api.v1.model.EnvironmentSummary;
import com.monarchapis.api.v1.model.EnvironmentUpdate;
import com.monarchapis.client.rest.Callback;

public interface EnvironmentsResourceAsync {

	public Future<EnvironmentList> queryEnvironments(EnvironmentsQuery query, Callback<EnvironmentList> callback);

	public Future<Environment> createEnvironment(EnvironmentUpdate body, Callback<Environment> callback);

	public Future<Environment> loadEnvironment(String id, Callback<Environment> callback);

	public Future<Environment> updateEnvironment(String id, EnvironmentUpdate body, Callback<Environment> callback);

	public Future<Environment> deleteEnvironment(String id, Callback<Environment> callback);

	public Future<EnvironmentSummary> getSummary(Callback<EnvironmentSummary> callback);
}