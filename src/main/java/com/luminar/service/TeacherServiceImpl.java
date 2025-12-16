package com.luminar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luminar.entity.Teacher;
import com.luminar.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	@Override
	public void saveTeacher(Teacher teacher) {
		if(teacher.getId() == null) {		//if id doesnt exist create new student
			teacherRepository.save(teacher); 
		}else {								//else updated student.with this we can avoid writing another method for updating
			Teacher teacherUpdate = teacherRepository.findById(teacher.getId()).get();
			teacherUpdate.setName(teacher.getName());
			teacherUpdate.setSubject(teacher.getSubject());
			teacherRepository.save(teacherUpdate);
			
			//calling findById sets teacherUpdate with current rows id if it exists
		}
		
	}
	/*
	 * findById returns an Optional<Teacher> to handle the absence of data safely. Calling get() extracts the entity, which 
	 * becomes a managed JPA entity within the persistence context.if optional is empty it throws an exception NoSuchElement
	 */

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll(); //returns a List of Teacher type
	}

	@Override
	public Teacher getTeacherById(Long id) {
		return teacherRepository.findById(id).get();
	}
	//findById fetches an optional<Teacher>. get returns a teacher object if optional contains value
	//else it throws exception

	@Override
	public void deleteTeacher(Teacher teacher) {
		teacherRepository.delete(teacher);
		
	}

}
