package edu.bnuz.fb.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.controller.LoginController;
import edu.bnuz.fb.rbac.entity.User;
import edu.bnuz.fb.rbac.service.UserService;

@Controller
@RequestMapping("/api")
public class Wx_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Wx_Controller.class);
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/wx_login")
	public ResultMsg wxLogin(User user) {
		ResultMsg msg = new ResultMsg();
		String userName = user.getUserName();
		String password = user.getPassword();
		logger.info("userName:"+userName+"登陆系统");
		if(userName!=null&&!userName.equals("")&&password!=null&&!password.equals("")) {
			String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
			user.setPassword(md5Password);
			msg = userService.findUserList(user);
		}
		return msg;
	}

}