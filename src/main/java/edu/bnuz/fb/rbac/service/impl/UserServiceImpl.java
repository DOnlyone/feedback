package edu.bnuz.fb.rbac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.rbac.entity.User;
import edu.bnuz.fb.rbac.mapper.UserMapper;
import edu.bnuz.fb.rbac.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userDao;

	@Override
	public ResultMsg createUser(User user) {
		ResultMsg msg = new ResultMsg();
		try {
			userDao.createUser(user);
			msg.setSuccess(true);
			msg.setResultMsg("记录已保存");
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setResultMsg("记录保存失败");
		}
		
		return msg;
	}

	@Override
	public ResultMsg findUserList(User user) {
		ResultMsg msg = new ResultMsg();
		List<User> findUsers = userDao.findUsers(user);
		if(findUsers!=null&&findUsers.size()>0) {
			msg.setSuccess(true);
			msg.setRows(findUsers);
			return msg;
		}
		msg.setSuccess(false);
		msg.setResultMsg("没有找到相关记录");
		return msg;
	}

	@Override
	public ResultMsg updateUser(User user) {
		ResultMsg msg = new ResultMsg();
		try {
			userDao.updateUserInfo(user);
			msg.setSuccess(true);
			msg.setResultMsg("用户信息已更新");
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setResultMsg("更新失败");
		}
		
		return msg;
	}

	@Override
	public ResultMsg deleteUsers(List userId) {
		ResultMsg msg = new ResultMsg();
		try {
			userDao.deleteUsers(userId);
			msg.setSuccess(true);
			msg.setResultMsg("用户已删除");
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setResultMsg("记录保存失败");
		}
		
		return msg;
	}

}
