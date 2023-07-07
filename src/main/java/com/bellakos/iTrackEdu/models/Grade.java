package com.bellakos.iTrackEdu.models;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "grades")

@ToString
@EqualsAndHashCode
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;
	
	@Column(name = "user_id")
	Long user_id;
	
	@Column(name = "course_id")
	Long course_id;
	
	@Column(name = "practice1")
	Float practice1;
	
	@Column(name = "practice2")
	Float practice2;
	
	@Column(name = "practice3")
	Float practice3;
	
	@Column(name = "practice4")
	Float practice4;
	
	@Column(name = "practice5")
	Float practice5;
	
	@Column(name = "partial_exam")
	Float partial_exam;
	
	@Column(name = "final_exam")
	Float final_exam;
	
}
