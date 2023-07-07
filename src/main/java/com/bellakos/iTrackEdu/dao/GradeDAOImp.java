package com.bellakos.iTrackEdu.dao;

import com.bellakos.iTrackEdu.models.Grade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GradeDAOImp implements GradeDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public List<Grade> getGrades(Long user_id) {
		String query = "FROM Grade WHERE user_id = :user_id";
		@SuppressWarnings("unchecked") List<Grade> resultList = entityManager.createQuery(query)
				.setParameter("user_id", user_id)
				.getResultList();
		
		return resultList;
	}
}
