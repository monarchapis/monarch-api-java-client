package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Result;
import com.monarchapis.api.v1.model.SetPassword;
import com.monarchapis.api.v1.model.User;
import com.monarchapis.api.v1.model.UserList;
import com.monarchapis.api.v1.model.UserUpdate;

public interface UsersResource {

	public UserList queryUsers(UsersQuery query);

	public void createUser(UserUpdate body);

	public User loadUser(String id);

	public User updateUser(String id, UserUpdate body);

	public User deleteUser(String id);

	public Result setPassword(String id, SetPassword body);
}