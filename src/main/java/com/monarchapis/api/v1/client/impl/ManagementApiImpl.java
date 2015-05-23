package com.monarchapis.api.v1.client.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.monarchapis.api.v1.client.ApplicationsResource;
import com.monarchapis.api.v1.client.ApplicationsResourceAsync;
import com.monarchapis.api.v1.client.ClientsResource;
import com.monarchapis.api.v1.client.ClientsResourceAsync;
import com.monarchapis.api.v1.client.DevelopersResource;
import com.monarchapis.api.v1.client.DevelopersResourceAsync;
import com.monarchapis.api.v1.client.EnvironmentsResource;
import com.monarchapis.api.v1.client.EnvironmentsResourceAsync;
import com.monarchapis.api.v1.client.LogEntriesResource;
import com.monarchapis.api.v1.client.LogEntriesResourceAsync;
import com.monarchapis.api.v1.client.ManagementApi;
import com.monarchapis.api.v1.client.MeResource;
import com.monarchapis.api.v1.client.MeResourceAsync;
import com.monarchapis.api.v1.client.MessagesResource;
import com.monarchapis.api.v1.client.MessagesResourceAsync;
import com.monarchapis.api.v1.client.ModulesResource;
import com.monarchapis.api.v1.client.ModulesResourceAsync;
import com.monarchapis.api.v1.client.PermissionsResource;
import com.monarchapis.api.v1.client.PermissionsResourceAsync;
import com.monarchapis.api.v1.client.PlansResource;
import com.monarchapis.api.v1.client.PlansResourceAsync;
import com.monarchapis.api.v1.client.PrincipalClaimsResource;
import com.monarchapis.api.v1.client.PrincipalClaimsResourceAsync;
import com.monarchapis.api.v1.client.PrincipalProfilesResource;
import com.monarchapis.api.v1.client.PrincipalProfilesResourceAsync;
import com.monarchapis.api.v1.client.ProvidersResource;
import com.monarchapis.api.v1.client.ProvidersResourceAsync;
import com.monarchapis.api.v1.client.RolesResource;
import com.monarchapis.api.v1.client.RolesResourceAsync;
import com.monarchapis.api.v1.client.ServicesResource;
import com.monarchapis.api.v1.client.ServicesResourceAsync;
import com.monarchapis.api.v1.client.TokensResource;
import com.monarchapis.api.v1.client.TokensResourceAsync;
import com.monarchapis.api.v1.client.UsersResource;
import com.monarchapis.api.v1.client.UsersResourceAsync;
import com.monarchapis.client.rest.RequestProcessor;
import com.monarchapis.client.rest.RestClientFactory;

public class ManagementApiImpl implements ManagementApi {
	private String baseUrl;
	private RestClientFactory clientFactory;
	private List<RequestProcessor> requestProcessors;

	public ManagementApiImpl(String baseUrl, RestClientFactory clientFactory, RequestProcessor... requestProcessors) {
		this(baseUrl, clientFactory, Lists.newArrayList(requestProcessors));
	}

	public ManagementApiImpl(String baseUrl, RestClientFactory clientFactory, List<RequestProcessor> requestProcessors) {
		baseUrl = StringUtils.removeEnd(baseUrl, "/");

		if (StringUtils.isBlank(baseUrl)) {
			throw new IllegalArgumentException("baseUrl must not be blank or null");
		}

		if (clientFactory == null) {
			throw new IllegalArgumentException("clientFactory must not be null");
		}

		this.baseUrl = baseUrl;
		this.clientFactory = clientFactory;
		this.requestProcessors = requestProcessors;
	}

	public ApplicationsResource getApplicationsResource() {
		return new ApplicationsResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public ApplicationsResourceAsync getApplicationsResourceAsync() {
		return new ApplicationsResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public ClientsResource getClientsResource() {
		return new ClientsResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public ClientsResourceAsync getClientsResourceAsync() {
		return new ClientsResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public DevelopersResource getDevelopersResource() {
		return new DevelopersResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public DevelopersResourceAsync getDevelopersResourceAsync() {
		return new DevelopersResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public EnvironmentsResource getEnvironmentsResource() {
		return new EnvironmentsResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public EnvironmentsResourceAsync getEnvironmentsResourceAsync() {
		return new EnvironmentsResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public LogEntriesResource getLogEntriesResource() {
		return new LogEntriesResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public LogEntriesResourceAsync getLogEntriesResourceAsync() {
		return new LogEntriesResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public MeResource getMeResource() {
		return new MeResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public MeResourceAsync getMeResourceAsync() {
		return new MeResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public MessagesResource getMessagesResource() {
		return new MessagesResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public MessagesResourceAsync getMessagesResourceAsync() {
		return new MessagesResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public ModulesResource getModulesResource() {
		return new ModulesResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public ModulesResourceAsync getModulesResourceAsync() {
		return new ModulesResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public PermissionsResource getPermissionsResource() {
		return new PermissionsResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public PermissionsResourceAsync getPermissionsResourceAsync() {
		return new PermissionsResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public PlansResource getPlansResource() {
		return new PlansResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public PlansResourceAsync getPlansResourceAsync() {
		return new PlansResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public PrincipalClaimsResource getPrincipalClaimsResource() {
		return new PrincipalClaimsResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public PrincipalClaimsResourceAsync getPrincipalClaimsResourceAsync() {
		return new PrincipalClaimsResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public PrincipalProfilesResource getPrincipalProfilesResource() {
		return new PrincipalProfilesResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public PrincipalProfilesResourceAsync getPrincipalProfilesResourceAsync() {
		return new PrincipalProfilesResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public ProvidersResource getProvidersResource() {
		return new ProvidersResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public ProvidersResourceAsync getProvidersResourceAsync() {
		return new ProvidersResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public RolesResource getRolesResource() {
		return new RolesResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public RolesResourceAsync getRolesResourceAsync() {
		return new RolesResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public ServicesResource getServicesResource() {
		return new ServicesResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public ServicesResourceAsync getServicesResourceAsync() {
		return new ServicesResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public TokensResource getTokensResource() {
		return new TokensResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public TokensResourceAsync getTokensResourceAsync() {
		return new TokensResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}

	public UsersResource getUsersResource() {
		return new UsersResourceImpl(baseUrl, clientFactory, requestProcessors);
	}

	public UsersResourceAsync getUsersResourceAsync() {
		return new UsersResourceAsyncImpl(baseUrl, clientFactory, requestProcessors);
	}
}