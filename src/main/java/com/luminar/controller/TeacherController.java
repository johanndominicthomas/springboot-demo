package com.luminar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.luminar.entity.Teacher;
import com.luminar.service.TeacherService;

@Controller
public class TeacherController {

		@Autowired
		TeacherService teacherService;
		
		/*Teachers List*/
		
		@GetMapping("/")
		public ModelAndView getAllTeachers() {
			ModelAndView mav = new ModelAndView("index");
			List<Teacher> teacherList = teacherService.getAllTeachers();
			mav.addObject("teachers", teacherList);
			return mav;
		}
		/*ModelAndView is internally same as  Model + String.
		 * In Model, we set model with object to send to view and return jsp file name String.
		 * In Model and View ,it holds both the jsp file name and the object to sent.
		 * MAV is older SpringBoot.Model+ String is the newer one and reduces code.
		 */
		
		/*Add Teacher*/
		
		@GetMapping("/add-teacher")
		public ModelAndView addTeacher() {
			ModelAndView mav = new ModelAndView("add_teacher");
			mav.addObject("command", new Teacher());   //command is available by MAV by default.we set it with an empty teacher object
			return mav;
		}
		
		/*Save Teacher*/
		
		@PostMapping("/save-teacher")
		public String saveTeacher(@ModelAttribute Teacher teacher) {
			teacherService.saveTeacher(teacher);
			return "redirect:/";
		}
		
		/*Edit Teacher*/
		
		@GetMapping("/teacher-update/{id}")
		public ModelAndView getStaff(@PathVariable("id") Long id) {
			ModelAndView mav = new ModelAndView("add_teacher");
			Teacher teacher = teacherService.getTeacherById(id);
			mav.addObject("command", teacher);
			return mav;
		}
		
		/*
		 * When Edit is clicked > get request along with id.
		 * Fetch Teacher Object using id and allocate to teacher
		 * Set Teacher object to command in mav.
		 * add_teacher.jsp is rendered with the values in teacher object.
		 * clicking submit sends post request to save/update teacher (/save-teacher).
		 */
		
		
}
