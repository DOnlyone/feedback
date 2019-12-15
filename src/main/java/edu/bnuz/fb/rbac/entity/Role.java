package edu.bnuz.fb.rbac.entity;

import java.util.List;

public class Role {
    private Long roleId;

    private String roleName;

    private String desc;
    
    private List<Authority> authList;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

	public List<Authority> getAuthList() {
		return authList;
	}

	public void setAuthList(List<Authority> authList) {
		this.authList = authList;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", desc=" + desc + ", authList=" + authList + "]";
	}
    
    
}