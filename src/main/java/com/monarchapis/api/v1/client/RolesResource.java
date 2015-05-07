package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Role;
import com.monarchapis.api.v1.model.RoleList;
import com.monarchapis.api.v1.model.RoleUpdate;

public interface RolesResource {

	public RoleList queryRoles(RolesQuery query);

	public void createRole(RoleUpdate body);

	public Role loadRole(String id);

	public Role updateRole(String id, RoleUpdate body);

	public Role deleteRole(String id);
}