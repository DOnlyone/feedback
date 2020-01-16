package edu.bnuz.fb.rbac.service;


import java.util.List;
import java.util.Map;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.rbac.entity.Authority;
import edu.bnuz.fb.rbac.entity.User;

public interface UserService {
	
	public static final String MOINTER = "monitor";
	
	public static final String CLASS_MASTER = "classMaster";
	
	public static final String MINISTER = "minister";
	
	public static final String DIRECTOR = "director";
	
		
	public ResultMsg createUser(User user) ;
	
	public ResultMsg findUserList(User user);
	
	public ResultMsg updateUser(User user);
	
	public ResultMsg deleteUsers(List user);
	
	public User getUserInfo(Map param);
	
	public List<Authority> getUserPremission(Map map);
	
	

}
