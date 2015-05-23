package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Provider;
import com.monarchapis.api.v1.model.ProviderList;
import com.monarchapis.api.v1.model.ProviderUpdate;

public interface ProvidersResource {

	public ProviderList query(ProvidersQuery query);

	public Provider create(ProviderUpdate body);

	public Provider load(String id);

	public Provider update(String id, ProviderUpdate body);

	public Provider delete(String id);
}