package com.monarchapis.api.v1.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import com.google.common.base.Optional;

public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String id;

	@NotNull
	private String name;

	private Optional<String> type = Optional.absent();

	private Optional<String> description = Optional.absent();

	@NotNull
	private Boolean accessControl;

	@NotNull
	private Set<String> hostnames;

	private Optional<String> uriPrefix = Optional.absent();

	private Optional<String> versionLocation = Optional.absent();

	private Optional<String> defaultVersion = Optional.absent();

	@NotNull
	private List<Operation> operations;

	@NotNull
	private Set<String> flags;

	@NotNull
	private Extended extended;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<String> getType() {
		return type;
	}

	public void setType(Optional<String> type) {
		this.type = type;
	}

	public Optional<String> getDescription() {
		return description;
	}

	public void setDescription(Optional<String> description) {
		this.description = description;
	}

	public Boolean isAccessControl() {
		return accessControl;
	}

	public void setAccessControl(Boolean accessControl) {
		this.accessControl = accessControl;
	}

	public Set<String> getHostnames() {
		return hostnames;
	}

	public void setHostnames(Set<String> hostnames) {
		this.hostnames = hostnames;
	}

	public Optional<String> getUriPrefix() {
		return uriPrefix;
	}

	public void setUriPrefix(Optional<String> uriPrefix) {
		this.uriPrefix = uriPrefix;
	}

	public Optional<String> getVersionLocation() {
		return versionLocation;
	}

	public void setVersionLocation(Optional<String> versionLocation) {
		this.versionLocation = versionLocation;
	}

	public Optional<String> getDefaultVersion() {
		return defaultVersion;
	}

	public void setDefaultVersion(Optional<String> defaultVersion) {
		this.defaultVersion = defaultVersion;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Set<String> getFlags() {
		return flags;
	}

	public void setFlags(Set<String> flags) {
		this.flags = flags;
	}

	public Extended getExtended() {
		return extended;
	}

	public void setExtended(Extended extended) {
		this.extended = extended;
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
