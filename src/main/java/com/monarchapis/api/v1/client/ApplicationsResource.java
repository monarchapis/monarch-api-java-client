package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Application;
import com.monarchapis.api.v1.model.ApplicationList;
import com.monarchapis.api.v1.model.ApplicationUpdate;
import com.monarchapis.api.v1.model.ClientList;
import com.monarchapis.api.v1.model.Developer;
import com.monarchapis.api.v1.model.DeveloperList;
import com.monarchapis.api.v1.model.Result;

public interface ApplicationsResource {

	public ApplicationList query(ApplicationsQuery query);

	public Application create(ApplicationUpdate body);

	public Application load(String id);

	public Application update(String id, ApplicationUpdate body);

	public Application delete(String id);

	public ClientList getClients(String id);

	public DeveloperList getDevelopers(String id);

	public Developer getDeveloper(String id, String developerId);

	public Developer addApplication(String id, String developerId);

	public Result removeDeveloper(String id, String developerId);
}