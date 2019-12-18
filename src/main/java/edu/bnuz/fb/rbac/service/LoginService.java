package edu.bnuz.fb.rbac.service;

import java.util.List;



import edu.bnuz.fb.rbac.entity.User;



public interface LoginService {
	
	public User getUserByName(String name);
	

	
	public User getUserAuthority(String username) ;
	
	

}
