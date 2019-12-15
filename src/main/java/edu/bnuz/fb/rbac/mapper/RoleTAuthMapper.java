package edu.bnuz.fb.rbac.mapper;

import edu.bnuz.fb.rbac.entity.RoleToAuth;
import org.springframework.stereotype.Component;

@Component
public interface RoleTAuthMapper {

    public void addRoleAuthItem(RoleToAuth roleToAuth);

    public void upateRoleAuthItem(RoleToAuth roleToAuth);
}
