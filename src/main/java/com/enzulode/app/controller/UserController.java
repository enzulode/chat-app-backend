package com.enzulode.app.controller;

import com.enzulode.app.dto.user.CreateUserDTO;
import com.enzulode.app.dto.user.RetrieveUserDTO;
import com.enzulode.app.dto.user.RetrieveUserResultDTO;
import com.enzulode.app.dto.user.UserOperationResultDTO;
import com.enzulode.app.service.UserService;
import com.enzulode.app.util.UserDTOMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
		value = "/api/v1/users",
		consumes = {"application/json", "application/json;charset=UTF-8"},
		produces = {"application/json", "application/json;charset=UTF-8"}
)
@RequiredArgsConstructor
@Slf4j
public class UserController
{
	private final UserDTOMapper userDTOMapper;
	private final UserService userService;

	@PostMapping
	public ResponseEntity<UserOperationResultDTO> createNewUser(@RequestBody CreateUserDTO userDTO)
	{
		log.info("Got new user-creation request");
		userService.save(userDTOMapper.map(userDTO));

		var responseBody = new UserOperationResultDTO("User creation succeed");
		return ResponseEntity.ok().body(responseBody);
	}

	@GetMapping
	public ResponseEntity<RetrieveUserResultDTO> getUserById(@RequestBody RetrieveUserDTO userDTO)
	{
		log.info("Got new user-retrieving request");
		var user = userService.findById(userDTO.id());
		return ResponseEntity.ok().body(userDTOMapper.map(user));
	}
}
