package ru.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springboot.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsername(String username);
}
