package com.luminar.service;

import java.util.List;

import com.luminar.entity.Teacher;

public interface TeacherService {
	void saveTeacher(Teacher teacher);
	
	List<Teacher> getAllTeachers();
	
	Teacher getTeacherById(Long id);
	
	void deleteTeacher(Teacher teacher);
}
