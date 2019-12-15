package edu.bnuz.fb.rbac.mapper;

import edu.bnuz.fb.rbac.entity.Role;
import org.springframework.stereotype.Component;

@Component
public interface RoleMapper {

    public void addRole(Role role);

    public void updateRole(Role role);

    public void queryRoleList(Role role);


}
