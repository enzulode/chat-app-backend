package com.enzulode.app.service;

import com.enzulode.app.model.User;
import com.enzulode.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService
{
	private final UserRepository userRepository;

	public boolean createNewUser(User user)
	{
		log.info("Creating new user");
		var result = userRepository.save(user);
		return result.getId() != null;
	}
}
