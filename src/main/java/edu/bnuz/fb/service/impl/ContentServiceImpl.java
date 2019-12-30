package edu.bnuz.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.entity.Content;
import edu.bnuz.fb.mapper.ContentMapper;
import edu.bnuz.fb.service.ContentService;

public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private ContentMapper contentDao;


	@Override
	public ResultMsg addContent(Content content) {
		ResultMsg msg = new ResultMsg();
		try {
			contentDao.insert(content);
			msg.setSuccess(true);
			msg.setResultMsg("记录已保存");
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setResultMsg("保存记录失败，请联系管理员");
		}
		return msg;
	}

	@Override
	public ResultMsg listContent(Content content) {
		ResultMsg msg = new ResultMsg();
		List<Content> list = contentDao.listContent(content);
		if(list!=null && list.size()>0) {
			msg.setSuccess(true);
			msg.setRows(list);
			return msg;
		}
		msg.setSuccess(false);
		msg.setResultMsg("没有找到相关记录");
		return msg;
	}

	@Override
	public ResultMsg updateContent(Content content) {
		ResultMsg msg = new ResultMsg();
		try {
			contentDao.updateContent(content);
			msg.setSuccess(true);
			msg.setResultMsg("记录修改成功");
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setResultMsg("保存记录失败，请联系管理员");
		}
		return msg;
	}
	
	

}
