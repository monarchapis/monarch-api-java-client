package com.monarchapis.api.v1.model;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import com.google.common.base.Optional;

public class Developer implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String id;

	@NotNull
	private String username;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private Set<String> roles;

	private Optional<String> company = Optional.absent();

	private Optional<String> title = Optional.absent();

	private Optional<String> email = Optional.absent();

	private Optional<String> phone = Optional.absent();

	private Optional<String> mobile = Optional.absent();

	private Optional<String> address1 = Optional.absent();

	private Optional<String> address2 = Optional.absent();

	private Optional<String> locality = Optional.absent();

	private Optional<String> region = Optional.absent();

	private Optional<String> postalCode = Optional.absent();

	private Optional<String> countryCode = Optional.absent();

	private Optional<String> registrationIp = Optional.absent();

	@NotNull
	private Extended extended;

	private Optional<String> externalId = Optional.absent();

	@NotNull
	private String createdBy;

	@NotNull
	private DateTime createdDate;

	@NotNull
	private String modifiedBy;

	@NotNull
	private DateTime modifiedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public Optional<String> getCompany() {
		return company;
	}

	public void setCompany(Optional<String> company) {
		this.company = company;
	}

	public Optional<String> getTitle() {
		return title;
	}

	public void setTitle(Optional<String> title) {
		this.title = title;
	}

	public Optional<String> getEmail() {
		return email;
	}

	public void setEmail(Optional<String> email) {
		this.email = email;
	}

	public Optional<String> getPhone() {
		return phone;
	}

	public void setPhone(Optional<String> phone) {
		this.phone = phone;
	}

	public Optional<String> getMobile() {
		return mobile;
	}

	public void setMobile(Optional<String> mobile) {
		this.mobile = mobile;
	}

	public Optional<String> getAddress1() {
		return address1;
	}

	public void setAddress1(Optional<String> address1) {
		this.address1 = address1;
	}

	public Optional<String> getAddress2() {
		return address2;
	}

	public void setAddress2(Optional<String> address2) {
		this.address2 = address2;
	}

	public Optional<String> getLocality() {
		return locality;
	}

	public void setLocality(Optional<String> locality) {
		this.locality = locality;
	}

	public Optional<String> getRegion() {
		return region;
	}

	public void setRegion(Optional<String> region) {
		this.region = region;
	}

	public Optional<String> getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Optional<String> postalCode) {
		this.postalCode = postalCode;
	}

	public Optional<String> getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Optional<String> countryCode) {
		this.countryCode = countryCode;
	}

	public Optional<String> getRegistrationIp() {
		return registrationIp;
	}

	public void setRegistrationIp(Optional<String> registrationIp) {
		this.registrationIp = registrationIp;
	}

	public Extended getExtended() {
		return extended;
	}

	public void setExtended(Extended extended) {
		this.extended = extended;
	}

	public Optional<String> getExternalId() {
		return externalId;
	}

	public void setExternalId(Optional<String> externalId) {
		this.externalId = externalId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public DateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(DateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
