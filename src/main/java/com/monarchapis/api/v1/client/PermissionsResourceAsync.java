package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Permission;
import com.monarchapis.api.v1.model.PermissionList;
import com.monarchapis.api.v1.model.PermissionUpdate;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.VoidCallback;

public interface PermissionsResourceAsync {

	public Future<PermissionList> queryPermissions(PermissionsQuery query, Callback<PermissionList> callback);

	public void createPermission(PermissionUpdate body, VoidCallback callback);

	public Future<Permission> loadPermission(String id, Callback<Permission> callback);

	public Future<Permission> updatePermission(String id, PermissionUpdate body, Callback<Permission> callback);

	public Future<Permission> deletePermission(String id, Callback<Permission> callback);
}