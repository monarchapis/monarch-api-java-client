package com.monarchapis.api.v1.client;

public interface ManagementApi {

	ApplicationsResource getApplicationsResource();

	ApplicationsResourceAsync getApplicationsResourceAsync();

	AuthenticatorsResource getAuthenticatorsResource();

	AuthenticatorsResourceAsync getAuthenticatorsResourceAsync();

	ClientsResource getClientsResource();

	ClientsResourceAsync getClientsResourceAsync();

	DevelopersResource getDevelopersResource();

	DevelopersResourceAsync getDevelopersResourceAsync();

	EnvironmentsResource getEnvironmentsResource();

	EnvironmentsResourceAsync getEnvironmentsResourceAsync();

	LogEntriesResource getLogEntriesResource();

	LogEntriesResourceAsync getLogEntriesResourceAsync();

	MeResource getMeResource();

	MeResourceAsync getMeResourceAsync();

	MessagesResource getMessagesResource();

	MessagesResourceAsync getMessagesResourceAsync();

	PermissionsResource getPermissionsResource();

	PermissionsResourceAsync getPermissionsResourceAsync();

	PlansResource getPlansResource();

	PlansResourceAsync getPlansResourceAsync();

	PoliciesResource getPoliciesResource();

	PoliciesResourceAsync getPoliciesResourceAsync();

	PrincipalClaimsResource getPrincipalClaimsResource();

	PrincipalClaimsResourceAsync getPrincipalClaimsResourceAsync();

	PrincipalProfilesResource getPrincipalProfilesResource();

	PrincipalProfilesResourceAsync getPrincipalProfilesResourceAsync();

	ProvidersResource getProvidersResource();

	ProvidersResourceAsync getProvidersResourceAsync();

	RolesResource getRolesResource();

	RolesResourceAsync getRolesResourceAsync();

	ServicesResource getServicesResource();

	ServicesResourceAsync getServicesResourceAsync();

	TokensResource getTokensResource();

	TokensResourceAsync getTokensResourceAsync();

	UsersResource getUsersResource();

	UsersResourceAsync getUsersResourceAsync();

}