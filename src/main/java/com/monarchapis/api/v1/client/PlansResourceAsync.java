package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Plan;
import com.monarchapis.api.v1.model.PlanList;
import com.monarchapis.api.v1.model.PlanUpdate;
import com.monarchapis.client.rest.Callback;

public interface PlansResourceAsync {

	public Future<PlanList> query(PlansQuery query, Callback<PlanList> callback);

	public Future<Plan> create(PlanUpdate body, Callback<Plan> callback);

	public Future<Plan> load(String id, Callback<Plan> callback);

	public Future<Plan> update(String id, PlanUpdate body, Callback<Plan> callback);

	public Future<Plan> delete(String id, Callback<Plan> callback);
}