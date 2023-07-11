package com.enzulode.app.service;

import com.enzulode.app.model.User;
import lombok.NonNull;

public interface UserService
{
	void save(@NonNull User user);
	User findById(@NonNull Long id);
}
