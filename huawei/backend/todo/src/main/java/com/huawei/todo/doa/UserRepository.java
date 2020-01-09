package com.huawei.todo.doa;

import com.huawei.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long>{

    @Query("select u from User u where u.username = :username and u.password =:password")
    User findByUsernameAndPassword(@Param("username") String username,
                                   @Param("password") String password);


    @Query("select u from User u where u.username = :username")
    User findUserbyUsername(@Param("username") String username);
}
