package com.huawei.todo;

import com.huawei.todo.doa.UserRepository;
import com.huawei.todo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TodoApplication.class)
public class UserRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void retrieve_user_by_un_pw(){

        User user = userRepository.findByUsernameAndPassword("erman", "pwd");

        Assert.assertNotNull(user);



    }
}
