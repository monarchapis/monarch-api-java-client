package com.monarchapis.api.v1.client.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.monarchapis.api.exception.ApiError;
import com.monarchapis.api.exception.ApiErrorException;
import com.monarchapis.api.v1.client.DevelopersQuery;
import com.monarchapis.api.v1.client.DevelopersResource;
import com.monarchapis.api.v1.model.Developer;
import com.monarchapis.api.v1.model.DeveloperList;
import com.monarchapis.api.v1.model.DeveloperUpdate;
import com.monarchapis.client.resource.AbstractResource;
import com.monarchapis.client.rest.BaseClient.CollectionFormat;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClient;
import com.monarchapis.client.rest.RestClientFactory;
import com.monarchapis.client.rest.RestResponse;

public class DevelopersResourceImpl extends AbstractResource implements DevelopersResource {
	public DevelopersResourceImpl(String baseUrl, RestClientFactory clientFactory,
			RequestProcessor... requestProcessors) {
		super(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public DevelopersResourceImpl(String baseUrl, RestClientFactory clientFactory,
			List<RequestProcessor> requestProcessors) {
		super(baseUrl, clientFactory, requestProcessors);
	}

	public DeveloperList queryDevelopers(DevelopersQuery query) {
		final RestClient client = newClient("GET", "/developers") //
				.accepts("application/json") //
				.addQuery("offset", query.getOffset()) //
				.addQuery("limit", query.getLimit()) //
				.addQueryCollection("id", query.getIds(), CollectionFormat.PIPES) //
				.addQueryCollection("username", query.getUsernames(), CollectionFormat.PIPES) //
				.addQueryCollection("firstName", query.getFirstNames(), CollectionFormat.PIPES) //
				.addQueryCollection("lastName", query.getLastNames(), CollectionFormat.PIPES) //
				.addQueryCollection("roles", query.getRoles(), CollectionFormat.PIPES) //
				.addQueryCollection("company", query.getCompanies(), CollectionFormat.PIPES) //
				.addQueryCollection("title", query.getTitles(), CollectionFormat.PIPES) //
				.addQueryCollection("email", query.getEmails(), CollectionFormat.PIPES) //
				.addQueryCollection("phone", query.getPhones(), CollectionFormat.PIPES) //
				.addQueryCollection("mobile", query.getMobiles(), CollectionFormat.PIPES) //
				.addQueryCollection("address1", query.getAddress1s(), CollectionFormat.PIPES) //
				.addQueryCollection("address2", query.getAddress2s(), CollectionFormat.PIPES) //
				.addQueryCollection("locality", query.getLocalities(), CollectionFormat.PIPES) //
				.addQueryCollection("region", query.getRegions(), CollectionFormat.PIPES) //
				.addQueryCollection("postalCode", query.getPostalCodes(), CollectionFormat.PIPES) //
				.addQueryCollection("countryCode", query.getCountryCodes(), CollectionFormat.PIPES) //
				.addQueryCollection("registrationIp", query.getRegistrationIps(), CollectionFormat.PIPES) //
				.addQueryCollection("externalId", query.getExternalIds(), CollectionFormat.PIPES);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, DeveloperList.class);
	}

	public void createDeveloper(DeveloperUpdate body) {
		require(body, "body is a required parameter.");

		final RestClient client = newClient("POST", "/developers") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setBody(toJson(body));

		signRequest(client);
		client.send();
	}

	public Developer loadDeveloper(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("GET", "/developers/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Developer.class);
	}

	public Developer updateDeveloper(String id, DeveloperUpdate body) {
		require(id, "id is a required parameter.");
		require(body, "body is a required parameter.");

		final RestClient client = newClient("PUT", "/developers/{id}") //
				.accepts("application/json") //
				.contentType("application/json") //
				.setPath("id", id) //
				.setBody(toJson(body));

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Developer.class);
	}

	public Developer deleteDeveloper(String id) {
		require(id, "id is a required parameter.");

		final RestClient client = newClient("DELETE", "/developers/{id}") //
				.accepts("application/json") //
				.setPath("id", id);

		signRequest(client);
		final RestResponse response = client.send();
		return parseAs(response, Developer.class);
	}

	@Override
	protected void throwErrorException(RestResponse response) {
		ApiError error = parseAs(response.getResponseBody(), ApiError.class);

		throw new ApiErrorException(error);
	}
}