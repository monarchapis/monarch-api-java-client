package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Client;
import com.monarchapis.api.v1.model.ClientList;
import com.monarchapis.api.v1.model.ClientUpdate;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.VoidCallback;

public interface ClientsResourceAsync {

	public Future<ClientList> queryClients(ClientsQuery query, Callback<ClientList> callback);

	public void createClient(ClientUpdate body, VoidCallback callback);

	public Future<Client> loadClient(String id, Callback<Client> callback);

	public Future<Client> updateClient(String id, ClientUpdate body, Callback<Client> callback);

	public Future<Client> deleteClient(String id, Callback<Client> callback);
}