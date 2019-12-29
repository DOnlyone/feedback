package edu.bnuz.fb.rbac.entity;

import java.util.List;

public class User {
	
    private Long userId;
    
    /**
     * 如果为学生为学号，教师为工号
     */
    private Integer userNo;
    
    /**
     * 登录名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
    
    /**
     * 班级（数据字典dic_id)
     */
    private Integer classNum;
    
    /**
     * 年级（数据字典dic_id)
     */
    private Integer gardeId;
    
    private String email;

    private String mobile;
    
    private String realName;
    
    /**
     * 岗位
     */
    private Integer title;

    private Byte sex;
    
    /**
     * 班级(汉字描述）
     */
    private String classStr;
    /**
     * 年级(汉字描述）
     */
    private String gradeStr;
    
    private List<Role> roleList;

    public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

    public Integer getGardeId() {
        return gardeId;
    }

    public void setGardeId(Integer gardeId) {
        this.gardeId = gardeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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


	public Integer getTitle() {
		return title;
	}

	public void setTitle(Integer title) {
		this.title = title;
	}

	public String getClassStr() {
		return classStr;
	}

	public void setClassStr(String classStr) {
		this.classStr = classStr;
	}

	public String getGradeStr() {
		return gradeStr;
	}

	public void setGradeStr(String gradeStr) {
		this.gradeStr = gradeStr;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNo=" + userNo + ", userName=" + userName + ", password=" + password
				+ ", classNum=" + classNum + ", gardeId=" + gardeId + ", email=" + email + ", mobile=" + mobile
				+ ", realName=" + realName + ", title=" + title + ", sex=" + sex + ", classStr=" + classStr
				+ ", gradeStr=" + gradeStr + ", roleList=" + roleList + "]";
	}

	
    
    
}