package edu.bnuz.fb.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.entity.Dic;
import edu.bnuz.fb.rbac.entity.User;
import edu.bnuz.fb.rbac.service.UserService;
import edu.bnuz.fb.service.SysDicService;

@Controller
public class StudentController {
	

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SysDicService sysDicService;
	
	
	
	@RequestMapping("/studentAdmin")
	public String show(Model model) {
		List<Dic> gradeList = sysDicService.getGradeList();
		model.addAttribute("gradeList", gradeList);
		System.out.println(gradeList);
		return "admin/student/studentList";
	}
	
	@ResponseBody
	@RequestMapping("/addUser")
	public ResultMsg addUser(User user) {
		ResultMsg msg = userService.createUser(user);
		System.out.println(user);

		return msg;
	}
	

}
