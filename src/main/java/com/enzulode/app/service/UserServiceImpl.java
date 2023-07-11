package com.enzulode.app.service;

import com.enzulode.app.exception.FailedToCreateUserException;
import com.enzulode.app.exception.UserNotFoundException;
import com.enzulode.app.model.User;
import com.enzulode.app.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService
{
	private final UserRepository userRepository;

	@Override
	public void save(@NonNull User user)
	{
		try
		{
			log.info("Creating new user");
			userRepository.save(user);
		}
		catch (DataIntegrityViolationException e)
		{
			throw new FailedToCreateUserException("Failed to create new user due to some reasons: " + e.getMessage(), e);
		}
	}

	@Override
	public User findById(@NonNull Long id)
	{
		log.info("Retrieving user by id");
		var userOptional = userRepository.findUserById(id);
		if (userOptional.isEmpty()) throw new UserNotFoundException("User does not exist");
		return userOptional.get();
	}
}
