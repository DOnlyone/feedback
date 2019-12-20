package edu.bnuz.fb.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.rbac.entity.User;
import edu.bnuz.fb.rbac.service.UserService;

@Controller
public class StudentController {
	

	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping("/studentAdmin")
	public String show() {
		return "admin/student/studentList";
	}
	
	@ResponseBody
	@RequestMapping("/addUser")
	public ResultMsg addUser(User user) {
		//ResultMsg msg = userService.createUser(user);
		System.out.println(user);

		return null;
	}
	

}
