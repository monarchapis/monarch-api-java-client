package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.PrincipalClaims;
import com.monarchapis.api.v1.model.PrincipalClaimsList;
import com.monarchapis.api.v1.model.PrincipalClaimsUpdate;

public interface PrincipalClaimsResource {

	public PrincipalClaimsList queryPrincipalClaims(PrincipalClaimsQuery query);

	public void createPlan(PrincipalClaimsUpdate body);

	public PrincipalClaims loadPrincipalClaims(String id);

	public PrincipalClaims updatePrincipalClaims(String id, PrincipalClaimsUpdate body);

	public PrincipalClaims deletePrincipalClaims(String id);
}