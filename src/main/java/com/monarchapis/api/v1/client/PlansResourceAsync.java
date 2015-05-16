package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Plan;
import com.monarchapis.api.v1.model.PlanList;
import com.monarchapis.api.v1.model.PlanUpdate;
import com.monarchapis.client.rest.Callback;

public interface PlansResourceAsync {

	public Future<PlanList> queryPlans(PlansQuery query, Callback<PlanList> callback);

	public Future<Plan> createPlan(PlanUpdate body, Callback<Plan> callback);

	public Future<Plan> loadPlan(String id, Callback<Plan> callback);

	public Future<Plan> updatePlan(String id, PlanUpdate body, Callback<Plan> callback);

	public Future<Plan> deletePlan(String id, Callback<Plan> callback);
}