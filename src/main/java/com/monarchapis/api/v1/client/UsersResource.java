package com.monarchapis.api.v1.client;

import com.monarchapis.api.v1.model.Result;
import com.monarchapis.api.v1.model.SetPassword;
import com.monarchapis.api.v1.model.User;
import com.monarchapis.api.v1.model.UserList;
import com.monarchapis.api.v1.model.UserUpdate;

public interface UsersResource {

	public UserList query(UsersQuery query);

	public User create(UserUpdate body);

	public User load(String id);

	public User update(String id, UserUpdate body);

	public User delete(String id);

	public Result setPassword(String id, SetPassword body);
}