package edu.bnuz.fb.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.rbac.entity.User;
import edu.bnuz.fb.rbac.service.LoginService;
import edu.bnuz.fb.rbac.service.UserService;
import edu.bnuz.fb.tools.VCodeGenerator;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserService userService;

	
	//@ResponseBody
	@RequestMapping("/login")
	public String login(User user,HttpSession session,Model model,String vcode) {
		ResultMsg msg = new ResultMsg();
		String userName = user.getUserName();
		String password = user.getPassword();
		String codeValue = (String) session.getAttribute("vcode");
		if(codeValue!=null&&!codeValue.equals(vcode)) {
			model.addAttribute("errorMsg", "输入的验证码有误，请重新输入");
			return "index";
		}
		logger.info("userName:"+userName+"登陆系统");
		// 添加用户认证信息
		if(userName!=null&&!userName.equals("")&&password!=null&&!password.equals("")) {
			String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
			user.setPassword(md5Password);
			ResultMsg userMsg = userService.findUserList(user);
			if(userMsg.isSuccess()) {
				List rows = userMsg.getRows();
				user = (User) rows.get(0);
				session.setAttribute("session_user", user);
				return "redirect:/home";
			}else {
				model.addAttribute("errorMsg", "用户名和密码错误，请重新输入");
			}
		}

//			String userInfoString = JSON.toJSONString(userInfo);
//			session.setAttribute("user", userInfo);
//			msg.setSuccess(true);
//			msg.setResultMsg(userInfoString);
//			return msg;
//		}else {
//			msg.setSuccess(false);
//			msg.setResultMsg("用户名或密码为空");
//			return msg;
//		}
//		Subject subject = SecurityUtils.getSubject();
//		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(), user.getPassword());
//		try { // 进行验证，这里可以捕获异常，然后返回对应信息
//			subject.login(usernamePasswordToken); // subject.checkRole("admin"); //
//			subject.checkPermissions("query", "add");
//		} catch (AuthenticationException e) {
//			e.printStackTrace();
//			return "账号或密码错误！";
//		} catch (AuthorizationException e) {
//			e.printStackTrace();
//			return "没有权限";
//		}

		return "index";
	}

	// 注解验角色和权限
	/*
	 * @RequiresRoles("admin")
	 * 
	 * @RequiresPermissions("add")
	 */
	@RequestMapping("/index")
	public String index() {

		return "index";
	}
	
	@RequestMapping("/home")
	public String home() {
		
		return "admin/home";
	}

	@ResponseBody
	@RequestMapping("/getVcode")
	public void getValidateCode(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		
		VCodeGenerator vcGenerator = new VCodeGenerator();
		//生成验证码
		String vcode = vcGenerator.generatorVCode();
		//将验证码保存在session域中,以便判断验证码是否正确
		request.getSession().setAttribute("vcode", vcode);
		//生成验证码图片
		BufferedImage vImg = vcGenerator.generatorRotateVCodeImage(vcode, true);
		//输出图像
		try {
			ImageIO.write(vImg, "gif", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "/admin/welcome";
	}
	
	@RequestMapping("/refresh")
	public String refresh() {
		
		return "/refresh";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		System.out.println("----------------------");
		HttpSession session = request.getSession();
		//session.
	
		return "/index";
	}
	
	
}

/**
 * 
 * import lombok.extern.slf4j.Slf4j; import
 * org.apache.shiro.authz.AuthorizationException; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ExceptionHandler;
 * 
 * @ControllerAdvice
 * @Slf4j public class MyExceptionHandler {
 * 
 * @ExceptionHandler
 * @ResponseBody public String ErrorHandler(AuthorizationException e) {
 *               log.error("没有通过权限验证！", e); return "没有通过权限验证！"; } }
 */
