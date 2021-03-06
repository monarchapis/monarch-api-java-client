package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Developer;
import com.monarchapis.api.v1.model.DeveloperList;
import com.monarchapis.api.v1.model.DeveloperUpdate;
import com.monarchapis.client.rest.Callback;

public interface DevelopersResourceAsync {

	public Future<DeveloperList> queryDevelopers(DevelopersQuery query, Callback<DeveloperList> callback);

	public Future<Developer> createDeveloper(DeveloperUpdate body, Callback<Developer> callback);

	public Future<Developer> loadDeveloper(String id, Callback<Developer> callback);

	public Future<Developer> updateDeveloper(String id, DeveloperUpdate body, Callback<Developer> callback);

	public Future<Developer> deleteDeveloper(String id, Callback<Developer> callback);
}