package com.enzulode.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "_user")
public class User
{
	@Id
	@SequenceGenerator(
			name = "user_id_sequence",
			sequenceName = "user_id_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_id_sequence"
	)
	private Long id;

	private final String firstname;

	private final String lastname;

	@Column(unique = true)
	private final String nickname;

	private final String password;

	private final Instant creationDate;
}
