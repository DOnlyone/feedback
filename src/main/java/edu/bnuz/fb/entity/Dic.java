package edu.bnuz.fb.entity;

public class Dic {
		
    private Long dicId;

    private String name;

    private String type;

    private String code;
    
    private String value;
    
    private int orderNum;
    
    private String remark;
    
    private int delFlag;
    
    private Long parentValue;

	public Long getDicId() {
		return dicId;
	}

	public void setDicId(Long dicId) {
		this.dicId = dicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	public Long getParentValue() {
		return parentValue;
	}

	public void setParentValue(Long parentValue) {
		this.parentValue = parentValue;
	}

	@Override
	public String toString() {
		return "Dic [dicId=" + dicId + ", name=" + name + ", type=" + type + ", code=" + code + ", value=" + value
				+ ", orderNum=" + orderNum + ", remark=" + remark + ", delFlag=" + delFlag + ", parentValue="
				+ parentValue + "]";
	}



 
}