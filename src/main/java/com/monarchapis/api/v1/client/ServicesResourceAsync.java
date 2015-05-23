package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Service;
import com.monarchapis.api.v1.model.ServiceList;
import com.monarchapis.api.v1.model.ServiceUpdate;
import com.monarchapis.client.rest.Callback;

public interface ServicesResourceAsync {

	public Future<ServiceList> query(ServicesQuery query, Callback<ServiceList> callback);

	public Future<Service> create(ServiceUpdate body, Callback<Service> callback);

	public Future<Service> load(String id, Callback<Service> callback);

	public Future<Service> update(String id, ServiceUpdate body, Callback<Service> callback);

	public Future<Service> delete(String id, Callback<Service> callback);
}