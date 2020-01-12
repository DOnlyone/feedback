package edu.bnuz.fb.rbac.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.rbac.entity.User;
import edu.bnuz.fb.rbac.mapper.UserMapper;
import edu.bnuz.fb.rbac.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	//private static final List<User> com.github.pagehelper.Page<User> = null;
	@Autowired
	private UserMapper userDao;

	@Override
	public ResultMsg createUser(User user) {
		ResultMsg msg = new ResultMsg();
		//MessageDigest.
		String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Password);
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
		PageHelper.startPage(1, 2);
		List<User> findUsers = userDao.findUsers(user);
		if(findUsers!=null&&findUsers.size()>0) {
			msg.setSuccess(true);
			msg.setRows(findUsers);
			//Page<User> page = (Page<User>) findUsers;
			PageInfo<User> page = new PageInfo(findUsers);
			msg.setTotal(page.getTotal());
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
			msg.setResultMsg("记录删除失败");
		}
		
		return msg;
	}
	
	@Override
	public User getUserInfo(Map param) {
		User queryUserDetail = userDao.queryUserDetail(param);
		return queryUserDetail;
	}

}
