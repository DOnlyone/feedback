package edu.bnuz.fb.rbac.mapper;

import org.springframework.stereotype.Component;

@Component
public interface UserTRoleMapper {

    public void addUserRoleItem();

    public void deleteUserRoleItem();
}
