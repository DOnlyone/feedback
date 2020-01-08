package edu.bnuz.fb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.bnuz.fb.entity.Content;

@Mapper
public interface ContentMapper {
	
	public void insert(Content content);
	
	public List<Content> listContent(Content content);
	
	public List<Content> updateContent(Content content);
	
	public List getContentDetail(Long itemId);

}
