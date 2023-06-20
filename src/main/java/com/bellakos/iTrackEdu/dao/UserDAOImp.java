package com.bellakos.iTrackEdu.dao;

import com.bellakos.iTrackEdu.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImp implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        @SuppressWarnings("unchecked") List<User> resultList = entityManager.createQuery(query).getResultList();
        return resultList;
    }
}
