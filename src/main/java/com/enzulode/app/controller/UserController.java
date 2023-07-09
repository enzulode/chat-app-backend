package com.enzulode.app.controller;

import com.enzulode.app.dto.user.NewUserDTO;
import com.enzulode.app.dto.user.UserCreationStatusDTO;
import com.enzulode.app.model.User;
import com.enzulode.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController
{

	private final UserService userService;

	@PostMapping
	public UserCreationStatusDTO createNewUser(@RequestBody NewUserDTO userDTO)
	{
		log.info("Got new user-creation request");

		var user = new User(
				userDTO.getFirstname(),
				userDTO.getLastname(),
				userDTO.getNickname(),
				userDTO.getPassword(),
				Instant.now()
		);

		var result = userService.createNewUser(user);
		return new UserCreationStatusDTO(result);
	}
}
