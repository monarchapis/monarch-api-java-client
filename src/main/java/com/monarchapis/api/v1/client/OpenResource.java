package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.ServiceInfo;

public interface OpenResource {

	public ServiceInfo getServiceInfo(String environmentName, String serviceName, String providerKey);
}