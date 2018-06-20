package ru.springboot.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.springboot.domain.Message;

public interface MessageRepository extends CrudRepository<Message,Integer> {
}
