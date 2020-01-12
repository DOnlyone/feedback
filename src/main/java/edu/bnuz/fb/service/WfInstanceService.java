package edu.bnuz.fb.service;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.entity.WfInstance;

public interface WfInstanceService {
	
	public ResultMsg createInstance(WfInstance wfInstance);
	
	public ResultMsg goNextNode(WfInstance wfInstance);

}
