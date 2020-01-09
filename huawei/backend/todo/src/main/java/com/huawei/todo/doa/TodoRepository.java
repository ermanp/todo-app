package com.huawei.todo.doa;

import com.huawei.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("select t from Todo t where t.user.id =:id")
    List<Todo> getTodoListByUserId(Long id);

    @Query("select t from Todo t where t.id =:id")
    Todo findTodoById(Long id);
}
