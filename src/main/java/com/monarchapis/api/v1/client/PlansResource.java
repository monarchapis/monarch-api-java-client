package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Plan;
import com.monarchapis.api.v1.model.PlanList;
import com.monarchapis.api.v1.model.PlanUpdate;

public interface PlansResource {

	public PlanList queryPlans(PlansQuery query);

	public Plan createPlan(PlanUpdate body);

	public Plan loadPlan(String id);

	public Plan updatePlan(String id, PlanUpdate body);

	public Plan deletePlan(String id);
}