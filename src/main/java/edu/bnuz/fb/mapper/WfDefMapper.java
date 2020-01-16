package edu.bnuz.fb.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.bnuz.fb.entity.WfDef;

@Mapper
public interface WfDefMapper {
	
	public List<WfDef> queryNextNode(Long currNodeId);
	
	public List<String> getWfDefListByRole(List param);

}
