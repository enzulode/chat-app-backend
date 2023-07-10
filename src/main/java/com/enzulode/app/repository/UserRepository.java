package com.enzulode.app.repository;

import com.enzulode.app.model.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
	Optional<User> findUserById(@NonNull Long id);
}
