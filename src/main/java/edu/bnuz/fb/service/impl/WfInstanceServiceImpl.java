package edu.bnuz.fb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.entity.WfInstance;
import edu.bnuz.fb.mapper.WfInstanceMapper;
import edu.bnuz.fb.service.WfInstanceService;


@Service
public class WfInstanceServiceImpl implements WfInstanceService {
	
	@Autowired
	private WfInstanceMapper wfInstanceMapper;

	@Override
	public ResultMsg createInstance(WfInstance wfInstance) {
		ResultMsg msg = new ResultMsg();
		try {
			wfInstanceMapper.createWfInstance(wfInstance);
			msg.setSuccess(true);
			msg.setResultMsg("记录已添加");
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setResultMsg("记录添加失败");
		}
		return msg;
	}

	@Override
	public ResultMsg goNextNode(WfInstance wfInstance) {
		// TODO Auto-generated method stub
		return null;
	}

}
