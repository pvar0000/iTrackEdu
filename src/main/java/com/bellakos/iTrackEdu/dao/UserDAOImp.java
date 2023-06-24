package com.bellakos.iTrackEdu.dao;

import com.bellakos.iTrackEdu.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
        String query = "FROM User WHERE email = :email";
        @SuppressWarnings("unchecked") List<User> resultList = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();

        if (resultList.isEmpty()) return false;

        String password = resultList.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        return argon2.verify(password, user.getPassword().toCharArray()); // Convert to char[] user.getPassword() before hashing
    }


}
