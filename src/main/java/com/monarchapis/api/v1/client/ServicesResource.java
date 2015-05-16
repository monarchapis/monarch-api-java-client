package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Service;
import com.monarchapis.api.v1.model.ServiceList;
import com.monarchapis.api.v1.model.ServiceUpdate;

public interface ServicesResource {

	public ServiceList queryServices(ServicesQuery query);

	public Service createService(ServiceUpdate body);

	public Service loadService(String id);

	public Service updateService(String id, ServiceUpdate body);

	public Service deleteService(String id);
}