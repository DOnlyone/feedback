package edu.bnuz.fb.entity;

import java.util.Date;

import edu.bnuz.fb.rbac.entity.User;

public class Content {
	
    private Long id;

    private User createUser;

    private String context;

    private String type;

    private Date cteateDate;

    private Long currentNode;

    /**
     * status = 0 临时保存
     * status = 1 已提交正在走流程
     * status = 2 办理完结
     */
    private Integer status;

    private String title;
    
    private String urgent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCteateDate() {
        return cteateDate;
    }

    public void setCteateDate(Date cteateDate) {
        this.cteateDate = cteateDate;
    }

    public Long getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Long currentNode) {
        this.currentNode = currentNode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

	public String getUrgent() {
		return urgent;
	}

	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", createUser=" + createUser + ", context=" + context + ", type=" + type
				+ ", cteateDate=" + cteateDate + ", currentNode=" + currentNode + ", status=" + status + ", title="
				+ title + ", urgent=" + urgent + "]";
	}


    
    
}