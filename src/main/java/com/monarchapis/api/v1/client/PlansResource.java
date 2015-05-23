package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Plan;
import com.monarchapis.api.v1.model.PlanList;
import com.monarchapis.api.v1.model.PlanUpdate;

public interface PlansResource {

	public PlanList query(PlansQuery query);

	public Plan create(PlanUpdate body);

	public Plan load(String id);

	public Plan update(String id, PlanUpdate body);

	public Plan delete(String id);
}