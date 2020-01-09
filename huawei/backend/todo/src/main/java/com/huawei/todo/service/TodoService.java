package com.huawei.todo.service;


import com.huawei.todo.model.Todo;

import java.util.List;


public interface TodoService {

    Todo findTodoById(long id);

    void deleteById(long id);

    Todo save(Todo todo);

    Todo update(Todo todo);

    List<Todo> getTodoListByUserId(Long id);
}
