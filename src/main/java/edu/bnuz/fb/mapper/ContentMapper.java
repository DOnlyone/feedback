package edu.bnuz.fb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.bnuz.fb.entity.Content;

@Mapper
public interface ContentMapper {
	
	public void insert(Content content);

}
