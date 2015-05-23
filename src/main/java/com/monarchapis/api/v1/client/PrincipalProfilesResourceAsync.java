package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.PrincipalProfile;
import com.monarchapis.api.v1.model.PrincipalProfileList;
import com.monarchapis.api.v1.model.PrincipalProfileUpdate;
import com.monarchapis.client.rest.Callback;

public interface PrincipalProfilesResourceAsync {

	public Future<PrincipalProfileList> query(PrincipalProfilesQuery query, Callback<PrincipalProfileList> callback);

	public Future<PrincipalProfile> create(PrincipalProfileUpdate body, Callback<PrincipalProfile> callback);

	public Future<PrincipalProfile> load(String id, Callback<PrincipalProfile> callback);

	public Future<PrincipalProfile> update(String id, PrincipalProfileUpdate body, Callback<PrincipalProfile> callback);

	public Future<PrincipalProfile> delete(String id, Callback<PrincipalProfile> callback);
}