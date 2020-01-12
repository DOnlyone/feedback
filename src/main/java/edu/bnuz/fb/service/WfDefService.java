package edu.bnuz.fb.service;

import java.util.List;

import edu.bnuz.fb.entity.WfDef;

public interface WfDefService {
	
	
	public List<WfDef> queryNextNode(Long currNodeId);

}
