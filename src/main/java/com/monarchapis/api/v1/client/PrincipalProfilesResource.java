package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.PrincipalProfile;
import com.monarchapis.api.v1.model.PrincipalProfileList;
import com.monarchapis.api.v1.model.PrincipalProfileUpdate;

public interface PrincipalProfilesResource {

	public PrincipalProfileList query(PrincipalProfilesQuery query);

	public PrincipalProfile create(PrincipalProfileUpdate body);

	public PrincipalProfile load(String id);

	public PrincipalProfile update(String id, PrincipalProfileUpdate body);

	public PrincipalProfile delete(String id);
}