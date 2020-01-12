package edu.bnuz.fb.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.bnuz.fb.entity.WfInstance;

@Mapper
public interface WfInstanceMapper {
	
	public void createWfInstance(WfInstance wfinstance);
	
	public void updateWFInstance(WfInstance wfinstance);


}
