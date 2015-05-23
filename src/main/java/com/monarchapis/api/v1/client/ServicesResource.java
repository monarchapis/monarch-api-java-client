package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Service;
import com.monarchapis.api.v1.model.ServiceList;
import com.monarchapis.api.v1.model.ServiceUpdate;

public interface ServicesResource {

	public ServiceList query(ServicesQuery query);

	public Service create(ServiceUpdate body);

	public Service load(String id);

	public Service update(String id, ServiceUpdate body);

	public Service delete(String id);
}