package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.PrincipalClaims;
import com.monarchapis.api.v1.model.PrincipalClaimsList;
import com.monarchapis.api.v1.model.PrincipalClaimsUpdate;
import com.monarchapis.client.rest.Callback;

public interface PrincipalClaimsResourceAsync {

	public Future<PrincipalClaimsList> queryPrincipalClaims(PrincipalClaimsQuery query,
			Callback<PrincipalClaimsList> callback);

	public Future<PrincipalClaims> createPlan(PrincipalClaimsUpdate body, Callback<PrincipalClaims> callback);

	public Future<PrincipalClaims> loadPrincipalClaims(String id, Callback<PrincipalClaims> callback);

	public Future<PrincipalClaims> updatePrincipalClaims(String id, PrincipalClaimsUpdate body,
			Callback<PrincipalClaims> callback);

	public Future<PrincipalClaims> deletePrincipalClaims(String id, Callback<PrincipalClaims> callback);
}