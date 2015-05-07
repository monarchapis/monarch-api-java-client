package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.ConfigurableList;
import com.monarchapis.client.rest.Callback;

public interface PoliciesResourceAsync {

	public Future<ConfigurableList> listPolicies(Callback<ConfigurableList> callback);
}