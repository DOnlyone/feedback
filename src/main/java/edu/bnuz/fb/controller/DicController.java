package edu.bnuz.fb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DicController {
	
	@RequestMapping("dicHome")
	public String DicHome() {
		
		return "dic_home";
	}

}
