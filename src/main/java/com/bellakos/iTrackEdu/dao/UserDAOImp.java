package com.bellakos.iTrackEdu.dao;

import com.bellakos.iTrackEdu.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImp implements UserDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        @SuppressWarnings("unchecked") List<User> resultList = entityManager.createQuery(query).getResultList();
        return resultList;
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void registerUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public boolean authenticate(User user) {
        String query = "FROM User WHERE email = :email AND password = :password";
        @SuppressWarnings("unchecked") List<User> resultList = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();

        return !resultList.isEmpty();
    }


}
