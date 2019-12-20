package edu.bnuz.fb.rbac.service.impl;

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

}
