package com.bellakos.iTrackEdu.controller;

import com.bellakos.iTrackEdu.dao.GradeDAO;
import com.bellakos.iTrackEdu.dao.UserDAO;
import com.bellakos.iTrackEdu.models.Grade;
import com.bellakos.iTrackEdu.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private GradeDAO gradeDAO;
	
	@RequestMapping(value = "api/grades", method = RequestMethod.GET)
	public List<Grade> getGrades(@RequestBody User user) {
		User userLoggedIn = userDAO.getUserByCredentials(user);
		Long user_id = userLoggedIn.getId();
		return gradeDAO.getGrades(user_id);
	}
}
