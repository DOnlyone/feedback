package edu.bnuz.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnuz.fb.entity.WfDef;
import edu.bnuz.fb.mapper.WfDefMapper;
import edu.bnuz.fb.service.WfDefService;

@Service
public class WfDefServiceImpl implements WfDefService {
	
	@Autowired
	private WfDefMapper WfDefDao;

	@Override
	public List<WfDef> queryNextNode(Long currNodeId) {
		
		return WfDefDao.queryNextNode(currNodeId);
	}

}
