package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Client;
import com.monarchapis.api.v1.model.ClientList;
import com.monarchapis.api.v1.model.ClientUpdate;
import com.monarchapis.client.rest.Callback;

public interface ClientsResourceAsync {

	public Future<ClientList> query(ClientsQuery query, Callback<ClientList> callback);

	public Future<Client> create(ClientUpdate body, Callback<Client> callback);

	public Future<Client> load(String id, Callback<Client> callback);

	public Future<Client> update(String id, ClientUpdate body, Callback<Client> callback);

	public Future<Client> delete(String id, Callback<Client> callback);
}