package com.bellakos.iTrackEdu.controller;

import com.bellakos.iTrackEdu.dao.UserDAO;
import com.bellakos.iTrackEdu.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "api/users")
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user) {
        userDAO.registerUser(user);
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        userDAO.deleteUser(id);
    }
}
