package com.enzulode.app.dto.user;

import lombok.*;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class NewUserDTO
{
	private final String firstname;
	private final String lastname;
	private final String nickname;
	private final String password;
}
