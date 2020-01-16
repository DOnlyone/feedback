package edu.bnuz.fb.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.bnuz.fb.entity.Content;

@Mapper
public interface ContentMapper {
	
	public Long insert(Content content);
	
	public List<Content> listContent(Content content);
	
	public void updateContent(Content content);
	
	public List getContentDetail(Map param);
	
	public List getContentbyType(Map param);
	
	public List queryContentByProcessRole(Map param);

}
