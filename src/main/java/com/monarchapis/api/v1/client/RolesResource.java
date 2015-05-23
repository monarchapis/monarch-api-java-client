package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Role;
import com.monarchapis.api.v1.model.RoleList;
import com.monarchapis.api.v1.model.RoleUpdate;

public interface RolesResource {

	public RoleList query(RolesQuery query);

	public Role create(RoleUpdate body);

	public Role load(String id);

	public Role update(String id, RoleUpdate body);

	public Role delete(String id);
}