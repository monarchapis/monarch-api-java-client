package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.UserPermissions;

public interface MeResource {

	public UserPermissions getPermissions();
}