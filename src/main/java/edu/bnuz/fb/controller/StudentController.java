package edu.bnuz.fb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@RequestMapping("/studentAdmin")
	public String show() {
		return "admin/student/studentList";
	}

}
