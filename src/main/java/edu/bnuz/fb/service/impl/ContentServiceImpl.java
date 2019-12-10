package edu.bnuz.fb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bnuz.fb.entity.Content;
import edu.bnuz.fb.mapper.ContentMapper;
import edu.bnuz.fb.service.ContentService;

public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private ContentMapper contentDao;

	@Override
	public void addContent(Content content) {
		// TODO Auto-generated method stub
		
	}
	
	

}
