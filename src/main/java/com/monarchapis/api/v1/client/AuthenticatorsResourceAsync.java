package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.ConfigurableList;
import com.monarchapis.client.rest.Callback;

public interface AuthenticatorsResourceAsync {

	public Future<ConfigurableList> listAuthenticators(Callback<ConfigurableList> callback);
}