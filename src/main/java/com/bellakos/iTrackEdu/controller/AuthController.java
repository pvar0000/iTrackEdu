package com.bellakos.iTrackEdu.controller;


import com.bellakos.iTrackEdu.dao.UserDAO;
import com.bellakos.iTrackEdu.models.User;
import com.bellakos.iTrackEdu.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        User userLoggedIn = userDAO.getUserByCredentials(user);

        if (userLoggedIn != null) {
            return jwtUtil.create(String.valueOf(userLoggedIn.getId()), userLoggedIn.getEmail());
        }
        return "FAILED";
    }
}
