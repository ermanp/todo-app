package com.huawei.todo.service.impl;

import com.huawei.todo.doa.TodoRepository;
import com.huawei.todo.model.Todo;
import com.huawei.todo.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {



    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo findTodoById(long id) {
        return todoRepository.findTodoById(id);
    }

    @Override
    public void deleteById(long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getTodoListByUserId(Long id) {
        return todoRepository.getTodoListByUserId(id);
    }
}
