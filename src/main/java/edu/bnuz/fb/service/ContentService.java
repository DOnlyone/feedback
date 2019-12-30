package edu.bnuz.fb.service;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.entity.Content;

public interface ContentService {
	
	public ResultMsg addContent(Content content);
	
	public ResultMsg listContent(Content content);
	
	public ResultMsg updateContent(Content content);

}
