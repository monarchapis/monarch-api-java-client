package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Provider;
import com.monarchapis.api.v1.model.ProviderList;
import com.monarchapis.api.v1.model.ProviderUpdate;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.VoidCallback;

public interface ProvidersResourceAsync {

	public Future<ProviderList> queryProviders(ProvidersQuery query, Callback<ProviderList> callback);

	public void createProvider(ProviderUpdate body, VoidCallback callback);

	public Future<Provider> loadProvider(String id, Callback<Provider> callback);

	public Future<Provider> updateProvider(String id, ProviderUpdate body, Callback<Provider> callback);

	public Future<Provider> deleteProvider(String id, Callback<Provider> callback);
}