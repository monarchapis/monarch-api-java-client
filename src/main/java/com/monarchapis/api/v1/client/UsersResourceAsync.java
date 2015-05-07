package com.monarchapis.api.v1.client;

import java.util.concurrent.Future;

import com.monarchapis.api.v1.model.Result;
import com.monarchapis.api.v1.model.SetPassword;
import com.monarchapis.api.v1.model.User;
import com.monarchapis.api.v1.model.UserList;
import com.monarchapis.api.v1.model.UserUpdate;
import com.monarchapis.client.rest.Callback;
import com.monarchapis.client.rest.VoidCallback;

public interface UsersResourceAsync {

	public Future<UserList> queryUsers(UsersQuery query, Callback<UserList> callback);

	public void createUser(UserUpdate body, VoidCallback callback);

	public Future<User> loadUser(String id, Callback<User> callback);

	public Future<User> updateUser(String id, UserUpdate body, Callback<User> callback);

	public Future<User> deleteUser(String id, Callback<User> callback);

	public Future<Result> setPassword(String id, SetPassword body, Callback<Result> callback);
}