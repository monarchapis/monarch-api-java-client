package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Provider;
import com.monarchapis.api.v1.model.ProviderList;
import com.monarchapis.api.v1.model.ProviderUpdate;

public interface ProvidersResource {

	public ProviderList queryProviders(ProvidersQuery query);

	public void createProvider(ProviderUpdate body);

	public Provider loadProvider(String id);

	public Provider updateProvider(String id, ProviderUpdate body);

	public Provider deleteProvider(String id);
}