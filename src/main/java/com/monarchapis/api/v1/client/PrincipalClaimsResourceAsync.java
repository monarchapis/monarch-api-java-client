package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.PrincipalClaims;
import com.monarchapis.api.v1.model.PrincipalClaimsList;
import com.monarchapis.api.v1.model.PrincipalClaimsUpdate;
import com.monarchapis.client.rest.Callback;

public interface PrincipalClaimsResourceAsync {

	public Future<PrincipalClaimsList> query(PrincipalClaimsQuery query, Callback<PrincipalClaimsList> callback);

	public Future<PrincipalClaims> create(PrincipalClaimsUpdate body, Callback<PrincipalClaims> callback);

	public Future<PrincipalClaims> load(String id, Callback<PrincipalClaims> callback);

	public Future<PrincipalClaims> update(String id, PrincipalClaimsUpdate body, Callback<PrincipalClaims> callback);

	public Future<PrincipalClaims> delete(String id, Callback<PrincipalClaims> callback);
}