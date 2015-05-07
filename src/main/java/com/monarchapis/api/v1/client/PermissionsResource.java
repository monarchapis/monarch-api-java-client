package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Permission;
import com.monarchapis.api.v1.model.PermissionList;
import com.monarchapis.api.v1.model.PermissionUpdate;

public interface PermissionsResource {

	public PermissionList queryPermissions(PermissionsQuery query);

	public void createPermission(PermissionUpdate body);

	public Permission loadPermission(String id);

	public Permission updatePermission(String id, PermissionUpdate body);

	public Permission deletePermission(String id);
}