package edu.bnuz.fb.common;

public class ResultMsg {
	
	private boolean success;
	
	private String resultMsg;
	
	private Object objData;
	
	private String resultData;

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

	public Object getObjData() {
		return objData;
	}

	public void setObjData(Object objData) {
		this.objData = objData;
	}

	public String getResultData() {
		return resultData;
	}

	public void setResultData(String resultData) {
		this.resultData = resultData;
	}

	@Override
	public String toString() {
		return "ResultMsg [success=" + success + ", resultMsg=" + resultMsg + ", objData=" + objData + ", resultData="
				+ resultData + "]";
	}
	


}
