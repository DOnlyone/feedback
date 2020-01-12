package edu.bnuz.fb.common;

import java.io.Serializable;
import java.util.List;

public class ResultMsg<T> implements Serializable {
	
	private Long total;
	
	private boolean success;
	
	private String resultMsg;
	
	private List<T> rows;
	
	private String resultData;
	
	private Long entityId;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public String getResultData() {
		return resultData;
	}

	public void setResultData(String resultData) {
		this.resultData = resultData;
	}
	

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	@Override
	public String toString() {
		return "ResultMsg [total=" + total + ", success=" + success + ", resultMsg=" + resultMsg + ", rows=" + rows
				+ ", resultData=" + resultData + ", entityId=" + entityId + "]";
	}


	
	


	
	


}
