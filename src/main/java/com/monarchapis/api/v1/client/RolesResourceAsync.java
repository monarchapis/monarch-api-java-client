package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Role;
import com.monarchapis.api.v1.model.RoleList;
import com.monarchapis.api.v1.model.RoleUpdate;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.VoidCallback;

public interface RolesResourceAsync {

	public Future<RoleList> queryRoles(RolesQuery query, Callback<RoleList> callback);

	public void createRole(RoleUpdate body, VoidCallback callback);

	public Future<Role> loadRole(String id, Callback<Role> callback);

	public Future<Role> updateRole(String id, RoleUpdate body, Callback<Role> callback);

	public Future<Role> deleteRole(String id, Callback<Role> callback);
}