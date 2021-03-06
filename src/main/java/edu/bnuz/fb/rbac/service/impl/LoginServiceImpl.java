package edu.bnuz.fb.rbac.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.UserTransactionAdapter;

import edu.bnuz.fb.rbac.entity.Authority;
import edu.bnuz.fb.rbac.entity.Role;

import edu.bnuz.fb.rbac.entity.User;
import edu.bnuz.fb.rbac.mapper.UserMapper;
import edu.bnuz.fb.rbac.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	

	@Autowired
	private UserMapper userMapper;

	
	@Override
	public User getUserByName(String name) {
		//权限1查询
		Authority auth = new Authority();
		auth.setAuthId(1l);
		auth.setAuthName("query");
		//权限2 add
		Authority auth1 = new Authority();
		auth1.setAuthId(2l);
		auth1.setAuthName("add");
		
        Set<Authority> permissionsSet = new HashSet<>();
        permissionsSet.add(auth);
        permissionsSet.add(auth1);
        
        
        Role role = new Role();
        role.setRoleId(1l);
        role.setRoleName("admin");
        
        

        
        
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        
        User user = new User();
        user.setUserId(1l);
        user.setUserName("test");
        user.setPassword("123456");

        
        Map<String ,User> map = new HashMap<>();
        map.put(user.getUserName(), user);

        Authority permissions3 = new Authority();
        permissions3.setAuthId(1l);
        permissions3.setAuthName("query");

		/*
		 * Set<Permissions> permissionsSet1 = new HashSet<>();
		 * permissionsSet1.add(permissions3); Role role1 = new
		 * Role("2","user",permissionsSet1); Set<Role> roleSet1 = new HashSet<>();
		 * roleSet1.add(role1); 
		 */
        User user1 = new User();
        user1.setUserId(2l);
        user1.setUserName("zhangsan");
        user1.setPassword("123456");
        
        
        
        map.put(user1.getUserName(), user1);
		return null;
	}




	
	/**
	 *根据用户名获取用户权限 用户名是用户登录名并非用户真实姓名
	 *1、如果用户存在
	 */
	@Override
	public User getUserAuthority(String username) {
		// TODO Auto-generated method stub
		//User user = userMapper.queryUserDetail(username);
		return null;
	}
	

}
