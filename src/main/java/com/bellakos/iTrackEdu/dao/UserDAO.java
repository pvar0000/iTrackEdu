package com.bellakos.iTrackEdu.dao;


import com.bellakos.iTrackEdu.models.User;

import java.util.List;

public interface UserDAO {
   List<User> getUsers();

   void deleteUser(Long id);

   void registerUser(User user);


   boolean authenticate(User user);
}
