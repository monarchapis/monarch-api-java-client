package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Application;
import com.monarchapis.api.v1.model.ApplicationList;
import com.monarchapis.api.v1.model.Authentication;
import com.monarchapis.api.v1.model.Developer;
import com.monarchapis.api.v1.model.DeveloperList;
import com.monarchapis.api.v1.model.DeveloperUpdate;
import com.monarchapis.api.v1.model.Result;
import com.monarchapis.api.v1.model.SetPassword;
import com.monarchapis.client.rest.Callback;

public interface DevelopersResourceAsync {

	public Future<DeveloperList> query(DevelopersQuery query, Callback<DeveloperList> callback);

	public Future<Developer> create(DeveloperUpdate body, Callback<Developer> callback);

	public Future<Developer> load(String id, Callback<Developer> callback);

	public Future<Developer> update(String id, DeveloperUpdate body, Callback<Developer> callback);

	public Future<Developer> delete(String id, Callback<Developer> callback);

	public Future<Result> setPassword(String id, SetPassword body, Callback<Result> callback);

	public Future<ApplicationList> getApplications(String id, Callback<ApplicationList> callback);

	public Future<Application> getApplication(String id, String applicationId, Callback<Application> callback);

	public Future<Application> addApplication(String id, String applicationId, Callback<Application> callback);

	public Future<Result> removeApplication(String id, String applicationId, Callback<Result> callback);

	public Future<Developer> authenticate(Authentication body, Callback<Developer> callback);
}