package com.me.springboot3todoapp.dataAccess.abstacts;

import com.me.springboot3todoapp.entities.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem,Long> {

}
