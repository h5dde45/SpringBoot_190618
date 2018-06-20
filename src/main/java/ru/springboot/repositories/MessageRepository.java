package ru.springboot.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.springboot.domain.Message;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Integer> {
    List<Message> findByTag(String tag);
}
