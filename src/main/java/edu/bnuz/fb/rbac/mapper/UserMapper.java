package edu.bnuz.fb.rbac.mapper;

import edu.bnuz.fb.rbac.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    public List<User> findUsers();

    public void createUser(User user);

    public void updateUserInfo(User user);


}
