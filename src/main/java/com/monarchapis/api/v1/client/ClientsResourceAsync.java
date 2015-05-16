package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Client;
import com.monarchapis.api.v1.model.ClientList;
import com.monarchapis.api.v1.model.ClientUpdate;
import com.monarchapis.client.rest.Callback;

public interface ClientsResourceAsync {

	public Future<ClientList> queryClients(ClientsQuery query, Callback<ClientList> callback);

	public Future<Client> createClient(ClientUpdate body, Callback<Client> callback);

	public Future<Client> loadClient(String id, Callback<Client> callback);

	public Future<Client> updateClient(String id, ClientUpdate body, Callback<Client> callback);

	public Future<Client> deleteClient(String id, Callback<Client> callback);
}