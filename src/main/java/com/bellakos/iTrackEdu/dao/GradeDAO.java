package com.bellakos.iTrackEdu.dao;


import com.bellakos.iTrackEdu.models.Grade;

import java.util.List;

public interface GradeDAO {
	List<Grade> getGrades(Long user_id);
}
