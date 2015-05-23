package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.PrincipalClaims;
import com.monarchapis.api.v1.model.PrincipalClaimsList;
import com.monarchapis.api.v1.model.PrincipalClaimsUpdate;

public interface PrincipalClaimsResource {

	public PrincipalClaimsList query(PrincipalClaimsQuery query);

	public PrincipalClaims create(PrincipalClaimsUpdate body);

	public PrincipalClaims load(String id);

	public PrincipalClaims update(String id, PrincipalClaimsUpdate body);

	public PrincipalClaims delete(String id);
}