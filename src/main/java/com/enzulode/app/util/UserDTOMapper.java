package com.enzulode.app.util;

import com.enzulode.app.dto.user.CreateUserDTO;
import com.enzulode.app.dto.user.RetrieveUserResultDTO;
import com.enzulode.app.model.User;
import lombok.NonNull;

public interface UserDTOMapper
{
	User map(@NonNull CreateUserDTO userDTO);
	RetrieveUserResultDTO map(@NonNull User user);
}
