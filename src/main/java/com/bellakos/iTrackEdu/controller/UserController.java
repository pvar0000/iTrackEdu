package com.bellakos.iTrackEdu.controller;

import com.bellakos.iTrackEdu.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "user")
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Juan");
        user.setLastName("Perez");
        user.setEmail("juanperez@gmail.com");
        user.setPassword("123456");
        return user;
    }
}
