package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Application;
import com.monarchapis.api.v1.model.ApplicationList;
import com.monarchapis.api.v1.model.ApplicationUpdate;
import com.monarchapis.api.v1.model.ClientList;
import com.monarchapis.api.v1.model.Developer;
import com.monarchapis.api.v1.model.DeveloperList;
import com.monarchapis.api.v1.model.Result;
import com.monarchapis.client.rest.Callback;

public interface ApplicationsResourceAsync {

	public Future<ApplicationList> query(ApplicationsQuery query, Callback<ApplicationList> callback);

	public Future<Application> create(ApplicationUpdate body, Callback<Application> callback);

	public Future<Application> load(String id, Callback<Application> callback);

	public Future<Application> update(String id, ApplicationUpdate body, Callback<Application> callback);

	public Future<Application> delete(String id, Callback<Application> callback);

	public Future<ClientList> getClients(String id, Callback<ClientList> callback);

	public Future<DeveloperList> getDevelopers(String id, Callback<DeveloperList> callback);

	public Future<Developer> getDeveloper(String id, String developerId, Callback<Developer> callback);

	public Future<Developer> addApplication(String id, String developerId, Callback<Developer> callback);

	public Future<Result> removeDeveloper(String id, String developerId, Callback<Result> callback);
}