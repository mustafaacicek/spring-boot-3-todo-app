package com.me.springboot3todoapp.business.abstracts;

import com.me.springboot3todoapp.entities.TodoItem;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TodoItemService {

    Iterable<TodoItem> getAll();

    Optional<TodoItem> getById(Long id);

    TodoItem save(TodoItem todoItem);

    void delete(TodoItem todoItem);



}
