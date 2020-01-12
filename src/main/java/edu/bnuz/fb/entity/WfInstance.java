package edu.bnuz.fb.entity;

import java.util.Date;
import java.util.List;

public class WfInstance {
	
	
    private Long instanceId;

    private Date createDate;

    private WfDef wfDef;
    
    private Long biz_Id;
    
    private Long createUser;
    
    private String opinion;

    public Long getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	public WfDef getWfDef() {
		return wfDef;
	}

	public void setWfDef(WfDef wfDef) {
		this.wfDef = wfDef;
	}

	public Long getBiz_Id() {
		return biz_Id;
	}

	public void setBiz_Id(Long biz_Id) {
		this.biz_Id = biz_Id;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
	
    
    
}