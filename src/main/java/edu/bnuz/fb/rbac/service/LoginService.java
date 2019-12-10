package edu.bnuz.fb.rbac.service;

import java.util.List;



import edu.bnuz.fb.rbac.entity.RoleToAuth;
import edu.bnuz.fb.rbac.entity.User;
import edu.bnuz.fb.rbac.entity.UserToRole;


public interface LoginService {
	
	public User getUserByName(String name);
	
	/**
	 *  
	 * @param userId
	 * @return
	 */
	public List<UserToRole> getUserTRole(Long userId);
	
	/**
	 * 根據角色id获取权限
	 * @param roleId
	 * @return
	 */
	public List<RoleToAuth> getRoleTAuth(Long roleId);
	
	

}
