package edu.bnuz.fb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {
	
	@RequestMapping("/teacherHome")
	public String teacherHome() {
		return "admin/teacherList";
	}

}
