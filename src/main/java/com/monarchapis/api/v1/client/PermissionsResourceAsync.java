package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Permission;
import com.monarchapis.api.v1.model.PermissionList;
import com.monarchapis.api.v1.model.PermissionUpdate;
import com.monarchapis.client.rest.Callback;

public interface PermissionsResourceAsync {

	public Future<PermissionList> query(PermissionsQuery query, Callback<PermissionList> callback);

	public Future<Permission> create(PermissionUpdate body, Callback<Permission> callback);

	public Future<Permission> load(String id, Callback<Permission> callback);

	public Future<Permission> update(String id, PermissionUpdate body, Callback<Permission> callback);

	public Future<Permission> delete(String id, Callback<Permission> callback);
}