package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Developer;
import com.monarchapis.api.v1.model.DeveloperList;
import com.monarchapis.api.v1.model.DeveloperUpdate;

public interface DevelopersResource {

	public DeveloperList queryDevelopers(DevelopersQuery query);

	public void createDeveloper(DeveloperUpdate body);

	public Developer loadDeveloper(String id);

	public Developer updateDeveloper(String id, DeveloperUpdate body);

	public Developer deleteDeveloper(String id);
}