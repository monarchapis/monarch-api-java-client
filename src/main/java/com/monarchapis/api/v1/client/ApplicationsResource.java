package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Application;
import com.monarchapis.api.v1.model.ApplicationList;
import com.monarchapis.api.v1.model.ApplicationUpdate;

public interface ApplicationsResource {

	public ApplicationList queryApplications(ApplicationsQuery query);

	public void createApplication(ApplicationUpdate body);

	public Application loadApplication(String id);

	public Application updateApplication(String id, ApplicationUpdate body);

	public Application deleteApplication(String id);
}