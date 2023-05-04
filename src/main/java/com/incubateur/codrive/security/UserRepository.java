package com.incubateur.codrive.security;

import com.incubateur.codrive.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByMail(String mail);

}
