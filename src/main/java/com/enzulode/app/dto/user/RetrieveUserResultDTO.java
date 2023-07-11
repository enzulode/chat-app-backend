package com.enzulode.app.dto.user;

import lombok.NonNull;

import java.time.Instant;

public record RetrieveUserResultDTO(
		@NonNull Long id,
		@NonNull String firstname,
		@NonNull String lastname,
		@NonNull String nickname,
		@NonNull Instant creationDate
)
{
}
