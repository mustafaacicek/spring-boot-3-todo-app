package com.me.springboot3todoapp.controller;

import com.me.springboot3todoapp.business.concrets.TodoItemManager;
import com.me.springboot3todoapp.entities.TodoItem;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class TodoFormController {

    @Autowired
    private TodoItemManager todoItemManager;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem){
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItems(@Valid TodoItem todoItem, BindingResult result, Model model){
        TodoItem item = new TodoItem();

        item.setDescription(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());

        todoItemManager.save(todoItem);

        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    private String deleteTodoItem(@PathVariable("id") Long id, Model model){
        TodoItem todoItem = todoItemManager
                .getById(id)
                .orElseThrow(()-> new IllegalArgumentException("TodoItem id: " + id + " not found "));

        todoItemManager.delete(todoItem);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        TodoItem todoItem = todoItemManager
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + "not found"));
        model.addAttribute("todo",todoItem);
        return "edit-todo-item";

    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model){
        TodoItem item = todoItemManager
                .getById(id)
                .orElseThrow(()-> new IllegalArgumentException("TodoITem id: " + id + "not found"));

        item.setIsComplete(todoItem.getIsComplete());
        item.setDescription(todoItem.getDescription());

        todoItemManager.save(item);

        return "redirect:/";
    }

}
