package com.enzulode.app.dto.user;

import lombok.*;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class UserCreationStatusDTO
{
	private final boolean result;
	private String message;
}
