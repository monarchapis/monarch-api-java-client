package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Provider;
import com.monarchapis.api.v1.model.ProviderList;
import com.monarchapis.api.v1.model.ProviderUpdate;
import com.monarchapis.client.rest.Callback;

public interface ProvidersResourceAsync {

	public Future<ProviderList> query(ProvidersQuery query, Callback<ProviderList> callback);

	public Future<Provider> create(ProviderUpdate body, Callback<Provider> callback);

	public Future<Provider> load(String id, Callback<Provider> callback);

	public Future<Provider> update(String id, ProviderUpdate body, Callback<Provider> callback);

	public Future<Provider> delete(String id, Callback<Provider> callback);
}