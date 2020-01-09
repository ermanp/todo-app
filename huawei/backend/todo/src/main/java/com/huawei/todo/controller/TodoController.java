package com.huawei.todo.controller;

import com.huawei.todo.model.Todo;
import com.huawei.todo.model.User;
import com.huawei.todo.service.TodoService;
import com.huawei.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {



    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){

        User user = userService.findUserbyUsername(username);

        List<Todo> todos = todoService.getTodoListByUserId(user.getId());

        List<Todo> representTodoList = new ArrayList<>();

        for(Todo todo : todos){
            representTodoList.add(new Todo(todo.getId(),todo.getDescription(),todo.getTargetDate(),todo.isDone()));
        }

        return representTodoList;

    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id){

        Todo todo = todoService.findTodoById(id);

        todo.setUser(null);

        return todo;


    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,
                                           @PathVariable long id){

        try{
            todoService.deleteById(id);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @PathVariable long id,
                                           @RequestBody Todo todo){
     //  Todo updatedTtodo = todoService.save(todo);

        Todo updatedTodo = todo;

        Todo currentTodo = todoService.findTodoById(id);

        currentTodo = updatedTodo;

        User user = userService.findUserbyUsername(username);

        currentTodo.setUser(user);

        todoService.save(currentTodo);

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> saveTodo(@PathVariable String username,
                                           @RequestBody Todo todo){
        
        User user = userService.findUserbyUsername(username);
        
        todo.setUser(user);

        Todo createdTodo = todoService.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/users/{username}/todos/change-status/{id}")
    public ResponseEntity<Todo> changeTodoStatus(@PathVariable long id){
        //  Todo updatedTtodo = todoService.save(todo);

        Todo todo = todoService.findTodoById(id);

        todo.setDone(!todo.isDone());

        todoService.save(todo);

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

}