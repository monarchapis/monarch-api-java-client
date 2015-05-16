package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Environment;
import com.monarchapis.api.v1.model.EnvironmentList;
import com.monarchapis.api.v1.model.EnvironmentSummary;
import com.monarchapis.api.v1.model.EnvironmentUpdate;

public interface EnvironmentsResource {

	public EnvironmentList queryEnvironments(EnvironmentsQuery query);

	public Environment createEnvironment(EnvironmentUpdate body);

	public Environment loadEnvironment(String id);

	public Environment updateEnvironment(String id, EnvironmentUpdate body);

	public Environment deleteEnvironment(String id);

	public EnvironmentSummary getSummary();
}