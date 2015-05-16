package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Service;
import com.monarchapis.api.v1.model.ServiceList;
import com.monarchapis.api.v1.model.ServiceUpdate;
import com.monarchapis.client.rest.Callback;

public interface ServicesResourceAsync {

	public Future<ServiceList> queryServices(ServicesQuery query, Callback<ServiceList> callback);

	public Future<Service> createService(ServiceUpdate body, Callback<Service> callback);

	public Future<Service> loadService(String id, Callback<Service> callback);

	public Future<Service> updateService(String id, ServiceUpdate body, Callback<Service> callback);

	public Future<Service> deleteService(String id, Callback<Service> callback);
}