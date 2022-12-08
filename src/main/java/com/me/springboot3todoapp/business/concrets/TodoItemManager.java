package com.me.springboot3todoapp.business.concrets;

import com.me.springboot3todoapp.business.abstracts.TodoItemService;
import com.me.springboot3todoapp.dataAccess.abstacts.TodoItemRepository;
import com.me.springboot3todoapp.entities.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class TodoItemManager implements TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;


    @Override
    public Iterable<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }

    @Override
    public Optional<TodoItem> getById(Long id) {
        return todoItemRepository.findById(id);
    }

    @Override
    public TodoItem save(TodoItem todoItem) {
        if (todoItem.getId()==null){
            todoItem.setCreatedAt(Instant.now());
        }
        todoItem.setUpdatedAt(Instant.now());
        return todoItemRepository.save(todoItem);
    }

    @Override
    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }
}
