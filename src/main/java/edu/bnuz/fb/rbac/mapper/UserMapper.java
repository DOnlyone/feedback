package edu.bnuz.fb.rbac.mapper;

import edu.bnuz.fb.rbac.entity.Authority;
import edu.bnuz.fb.rbac.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    public List<User> findUsers(User user);

    public void createUser(User user);

    public void updateUserInfo(User user);
    
    public User queryUserDetail(Map param);
    
    public void deleteUsers(List userIds);

	public List<Authority> getUserPremission(Map map);
    
    


}
