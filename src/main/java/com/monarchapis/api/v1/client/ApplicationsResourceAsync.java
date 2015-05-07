package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Application;
import com.monarchapis.api.v1.model.ApplicationList;
import com.monarchapis.api.v1.model.ApplicationUpdate;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.VoidCallback;

public interface ApplicationsResourceAsync {

	public Future<ApplicationList> queryApplications(ApplicationsQuery query, Callback<ApplicationList> callback);

	public void createApplication(ApplicationUpdate body, VoidCallback callback);

	public Future<Application> loadApplication(String id, Callback<Application> callback);

	public Future<Application> updateApplication(String id, ApplicationUpdate body, Callback<Application> callback);

	public Future<Application> deleteApplication(String id, Callback<Application> callback);
}