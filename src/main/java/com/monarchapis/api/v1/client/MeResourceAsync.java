package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.UserPermissions;
import com.monarchapis.client.rest.Callback;

public interface MeResourceAsync {

	public Future<UserPermissions> getPermissions(Callback<UserPermissions> callback);
}