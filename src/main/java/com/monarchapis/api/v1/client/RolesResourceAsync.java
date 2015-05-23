package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Role;
import com.monarchapis.api.v1.model.RoleList;
import com.monarchapis.api.v1.model.RoleUpdate;
import com.monarchapis.client.rest.Callback;

public interface RolesResourceAsync {

	public Future<RoleList> query(RolesQuery query, Callback<RoleList> callback);

	public Future<Role> create(RoleUpdate body, Callback<Role> callback);

	public Future<Role> load(String id, Callback<Role> callback);

	public Future<Role> update(String id, RoleUpdate body, Callback<Role> callback);

	public Future<Role> delete(String id, Callback<Role> callback);
}