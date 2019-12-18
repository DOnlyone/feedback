package edu.bnuz.fb.rbac.entity;

import java.util.List;

public class User {
    private Long id;

    private Integer userNo;

    private String userName;

    private String password;

    private Integer classNum;

    private Integer garde;

    private String email;

    private String phone;
    
    private String realName;

    private Byte sex;
    
    private List<Role> roleList;

    public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public Integer getGarde() {
        return garde;
    }

    public void setGarde(Integer garde) {
        this.garde = garde;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }
    

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userNo=" + userNo + ", userName=" + userName + ", password=" + password
				+ ", classNum=" + classNum + ", garde=" + garde + ", email=" + email + ", phone=" + phone + ", sex="
				+ sex + ", roleList=" + roleList + "]";
	}
    
    
}