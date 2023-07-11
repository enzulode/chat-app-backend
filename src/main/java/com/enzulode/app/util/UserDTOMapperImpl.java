package com.enzulode.app.util;

import com.enzulode.app.dto.user.CreateUserDTO;
import com.enzulode.app.dto.user.RetrieveUserResultDTO;
import com.enzulode.app.model.User;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserDTOMapperImpl implements UserDTOMapper
{
	@Override
	public User map(@NonNull CreateUserDTO userDTO)
	{
		return new User(
				userDTO.firstname(),
				userDTO.lastname(),
				userDTO.nickname(),
				userDTO.password(),
				Instant.now()
		);
	}

	@Override
	public RetrieveUserResultDTO map(@NonNull User user)
	{
		return new RetrieveUserResultDTO(
				user.getId(),
				user.getFirstname(),
				user.getLastname(),
				user.getNickname(),
				user.getCreationDate()
		);
	}
}
