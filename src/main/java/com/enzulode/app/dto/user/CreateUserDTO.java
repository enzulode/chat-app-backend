package com.enzulode.app.dto.user;

import lombok.NonNull;
import lombok.experimental.NonFinal;

public record CreateUserDTO(
		@NonFinal String firstname,
		@NonNull String lastname,
		@NonNull String nickname,
		@NonNull String password
)
{
}
