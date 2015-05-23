package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Application;
import com.monarchapis.api.v1.model.ApplicationList;
import com.monarchapis.api.v1.model.Authentication;
import com.monarchapis.api.v1.model.Developer;
import com.monarchapis.api.v1.model.DeveloperList;
import com.monarchapis.api.v1.model.DeveloperUpdate;
import com.monarchapis.api.v1.model.Result;
import com.monarchapis.api.v1.model.SetPassword;

public interface DevelopersResource {

	public DeveloperList query(DevelopersQuery query);

	public Developer create(DeveloperUpdate body);

	public Developer load(String id);

	public Developer update(String id, DeveloperUpdate body);

	public Developer delete(String id);

	public Result setPassword(String id, SetPassword body);

	public ApplicationList getApplications(String id);

	public Application getApplication(String id, String applicationId);

	public Application addApplication(String id, String applicationId);

	public Result removeApplication(String id, String applicationId);

	public Developer authenticate(Authentication body);
}