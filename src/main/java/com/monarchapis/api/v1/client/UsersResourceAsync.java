package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Result;
import com.monarchapis.api.v1.model.SetPassword;
import com.monarchapis.api.v1.model.User;
import com.monarchapis.api.v1.model.UserList;
import com.monarchapis.api.v1.model.UserUpdate;
import com.monarchapis.client.rest.Callback;

public interface UsersResourceAsync {

	public Future<UserList> query(UsersQuery query, Callback<UserList> callback);

	public Future<User> create(UserUpdate body, Callback<User> callback);

	public Future<User> load(String id, Callback<User> callback);

	public Future<User> update(String id, UserUpdate body, Callback<User> callback);

	public Future<User> delete(String id, Callback<User> callback);

	public Future<Result> setPassword(String id, SetPassword body, Callback<Result> callback);
}