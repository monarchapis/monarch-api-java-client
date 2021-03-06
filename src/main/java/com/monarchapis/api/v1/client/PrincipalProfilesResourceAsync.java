package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.PrincipalProfile;
import com.monarchapis.api.v1.model.PrincipalProfileList;
import com.monarchapis.api.v1.model.PrincipalProfileUpdate;
import com.monarchapis.client.rest.Callback;

public interface PrincipalProfilesResourceAsync {

	public Future<PrincipalProfileList> queryPrincipalProfile(PrincipalProfilesQuery query,
			Callback<PrincipalProfileList> callback);

	public Future<PrincipalProfile> createPlan(PrincipalProfileUpdate body, Callback<PrincipalProfile> callback);

	public Future<PrincipalProfile> loadPrincipalProfile(String id, Callback<PrincipalProfile> callback);

	public Future<PrincipalProfile> updatePrincipalProfile(String id, PrincipalProfileUpdate body,
			Callback<PrincipalProfile> callback);

	public Future<PrincipalProfile> deletePrincipalProfile(String id, Callback<PrincipalProfile> callback);
}