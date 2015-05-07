package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.ServiceInfo;
import com.monarchapis.client.rest.Callback;

public interface OpenResourceAsync {

	public Future<ServiceInfo> getServiceInfo(String environmentName, String serviceName, String providerKey,
			Callback<ServiceInfo> callback);
}