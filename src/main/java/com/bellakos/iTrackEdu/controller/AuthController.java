package com.bellakos.iTrackEdu.controller;


import com.bellakos.iTrackEdu.dao.UserDAO;
import com.bellakos.iTrackEdu.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        if (userDAO.authenticate(user)) return "OK";
        return "ERROR";
    }
}
