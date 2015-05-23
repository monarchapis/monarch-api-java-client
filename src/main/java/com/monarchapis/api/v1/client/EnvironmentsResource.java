package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Environment;
import com.monarchapis.api.v1.model.EnvironmentList;
import com.monarchapis.api.v1.model.EnvironmentSummary;
import com.monarchapis.api.v1.model.EnvironmentUpdate;

public interface EnvironmentsResource {

	public EnvironmentList query(EnvironmentsQuery query);

	public Environment create(EnvironmentUpdate body);

	public Environment load(String id);

	public Environment update(String id, EnvironmentUpdate body);

	public Environment delete(String id);

	public EnvironmentSummary getSummary();
}