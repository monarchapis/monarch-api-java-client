package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Permission;
import com.monarchapis.api.v1.model.PermissionList;
import com.monarchapis.api.v1.model.PermissionUpdate;

public interface PermissionsResource {

	public PermissionList query(PermissionsQuery query);

	public Permission create(PermissionUpdate body);

	public Permission load(String id);

	public Permission update(String id, PermissionUpdate body);

	public Permission delete(String id);
}