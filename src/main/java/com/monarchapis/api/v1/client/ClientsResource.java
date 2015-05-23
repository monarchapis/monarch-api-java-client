package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Client;
import com.monarchapis.api.v1.model.ClientList;
import com.monarchapis.api.v1.model.ClientUpdate;

public interface ClientsResource {

	public ClientList query(ClientsQuery query);

	public Client create(ClientUpdate body);

	public Client load(String id);

	public Client update(String id, ClientUpdate body);

	public Client delete(String id);
}