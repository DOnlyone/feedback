package edu.bnuz.fb.rbac.service;


import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.rbac.entity.User;

public interface UserService {
	

	
	public ResultMsg createUser(User user) ;
	
	public ResultMsg findUserList(User user);
	
	public ResultMsg updateUser(User user);

}
