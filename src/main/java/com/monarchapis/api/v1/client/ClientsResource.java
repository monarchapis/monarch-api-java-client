package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Client;
import com.monarchapis.api.v1.model.ClientList;
import com.monarchapis.api.v1.model.ClientUpdate;

public interface ClientsResource {

	public ClientList queryClients(ClientsQuery query);

	public Client createClient(ClientUpdate body);

	public Client loadClient(String id);

	public Client updateClient(String id, ClientUpdate body);

	public Client deleteClient(String id);
}