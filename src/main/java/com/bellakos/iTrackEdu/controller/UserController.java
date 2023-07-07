package com.bellakos.iTrackEdu.controller;

import com.bellakos.iTrackEdu.dao.GradeDAO;
import com.bellakos.iTrackEdu.dao.UserDAO;
import com.bellakos.iTrackEdu.models.User;
import com.bellakos.iTrackEdu.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private GradeDAO gradeDAO;

    @Autowired
    private JWTUtil jwtUtil;
    
    
    @RequestMapping(value = "api/users")
    public List<User> getUsers(@RequestHeader(value="Authorization") String token) {
        if (validateToken(token)) return null;
        return userDAO.getUsers();
    }

    //Use argon2 to hash the password before saving it to the database
    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        char[] password = user.getPassword().toCharArray(); // Convert to char[] before hashing
        String hash = argon2.hash(1, 1024, 1, password);
        user.setPassword(hash);
        userDAO.registerUser(user);
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@RequestHeader(value="Authorization") String token, @PathVariable Long id) {
        if (validateToken(token)) return;
        userDAO.deleteUser(id);
    }

    private boolean validateToken(String token) {
        String userId = jwtUtil.getKey(token);
        return userId == null;
    }
}
