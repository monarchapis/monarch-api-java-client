package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.PrincipalProfile;
import com.monarchapis.api.v1.model.PrincipalProfileList;
import com.monarchapis.api.v1.model.PrincipalProfileUpdate;

public interface PrincipalProfilesResource {

	public PrincipalProfileList queryPrincipalProfile(PrincipalProfilesQuery query);

	public void createPlan(PrincipalProfileUpdate body);

	public PrincipalProfile loadPrincipalProfile(String id);

	public PrincipalProfile updatePrincipalProfile(String id, PrincipalProfileUpdate body);

	public PrincipalProfile deletePrincipalProfile(String id);
}