package edu.bnuz.fb.controller.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.controller.LoginController;
import edu.bnuz.fb.entity.Content;
import edu.bnuz.fb.entity.WfDef;
import edu.bnuz.fb.entity.WfInstance;
import edu.bnuz.fb.rbac.entity.User;
import edu.bnuz.fb.rbac.service.UserService;
import edu.bnuz.fb.service.ContentService;
import edu.bnuz.fb.service.WfDefService;
import edu.bnuz.fb.service.WfInstanceService;

@Controller
@RequestMapping("/api")
public class Wx_Controller {

	private static final Logger logger = LoggerFactory.getLogger(Wx_Controller.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ContentService contentService;

	@Autowired
	private WfInstanceService wfInstanceService;

	@Autowired
	private WfDefService wfDefService;

	@ResponseBody
	@RequestMapping("/wx_login")
	public ResultMsg wxLogin(User user) {
		ResultMsg msg = new ResultMsg();
		String userName = user.getUserName();
		String password = user.getPassword();
		logger.info("userName:" + userName + "登陆系统");
		if (userName != null && !userName.equals("") && password != null && !password.equals("")) {
			String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
			user.setPassword(md5Password);
			msg = userService.findUserList(user);
			if (msg.isSuccess()) {
				List<User> rows = msg.getRows();
				User loginUser = rows.get(0);
				Long userId = loginUser.getUserId();
				Map map = new HashMap();
				map.put("userId", userId);
				User userInfo = userService.getUserInfo(map);
				String userStr = JSON.toJSONString(userInfo);
				msg.setResultData(userStr);

			} else {
				return msg;
			}
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping("/saveContent")
	public ResultMsg saveContent(@RequestBody Content content) {
		logger.info("新增内容" + content);
		return contentService.addContent(content);
		// return null;
	}

	@ResponseBody
	@RequestMapping("/listContent")
	public ResultMsg listContent(@RequestBody Content content) {
		logger.info("传入参数有" + content);
		return contentService.listContent(content);
	}

	@ResponseBody
	@RequestMapping("/getContentDetail")
	public ResultMsg getContentDetail(@RequestParam Map param) {
		logger.info("传入参数有" + param);
		return contentService.getContentDetail(param);
	}

	@ResponseBody
	@RequestMapping("/getContentbyType")
	public ResultMsg getContentbyType(@RequestParam List types) {
		logger.info("传入参数有" + types);
		Map param = new HashMap();
		param.put("types", types);
		return contentService.getContentbyType(param);
	}

	@ResponseBody
	@RequestMapping("/submitDoc")
	public ResultMsg submitDoc(@RequestBody Content content) {
		ResultMsg msg = new ResultMsg();
		Long id = content.getId();
		if (id == null) {
			msg = contentService.addContent(content);
			id = msg.getEntityId();
		} else {
			content.setCurrentNode(1l);
			msg = contentService.updateContent(content);
		}

		if (msg.isSuccess()) {
			WfInstance wfInstance = new WfInstance();
			wfInstance.setBiz_Id(id);
			WfDef wfDef = new WfDef();
			wfDef.setNodeId(1l);
			wfInstance.setWfDef(wfDef);
			wfInstance.setCreateDate(new Date());
			wfInstance.setCreateUser(content.getCreateUser().getUserId());
			msg = wfInstanceService.createInstance(wfInstance);
			return msg;
		}

		return msg;
	}

	@ResponseBody
	@RequestMapping("/goNextNode")
	public ResultMsg goNextNode(@RequestParam Map<String, String> param) {
		ResultMsg msg = new ResultMsg();
		String endFlag = param.get("endFlag");
		String Id = param.get("itemId");
		String userId = param.get("userId");
		Content content = new Content();
		content.setId(Long.valueOf(Id));
		if (endFlag.equals("1")) {// 完结
			content.setStatus(2);
			msg = contentService.updateContent(content);
			msg.setResultMsg("已成功办结");
		} else {// 需要查询下个节点，并流转到下个节点
			String currentNode = param.get("currentNode");
			// 查询下一个节点
			List<WfDef> wfDefList = wfDefService.queryNextNode(Long.valueOf(currentNode));
			if (wfDefList != null && wfDefList.size() > 0) {
				WfDef wfDef = wfDefList.get(0);
				Long nextNode = wfDef.getNextNode();
				content.setCurrentNode(nextNode);// 设置文档的当前节点
				msg = contentService.updateContent(content);

				WfInstance wfInstance = new WfInstance();
				wfInstance.setWfDef(wfDef);
				wfInstance.setCreateDate(new Date());
				wfInstance.setCreateUser(Long.valueOf(userId));
				wfInstance.setBiz_Id(Long.valueOf(Id));
				msg = wfInstanceService.createInstance(wfInstance);
				msg.setResultMsg("已经提交到" + wfDef.getNodeName());
			} else {// 下一个节点为null则办结
				content.setStatus(2);
				msg = contentService.updateContent(content);
				msg.setResultMsg("已成功办结");
			}
		}

		return msg;
	}

}
