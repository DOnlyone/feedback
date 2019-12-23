package edu.bnuz.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.entity.Dic;
import edu.bnuz.fb.mapper.DicMapper;
import edu.bnuz.fb.service.SysDicService;

@Service
public class SysDicServiceImpl implements SysDicService {
	
	@Autowired
	private DicMapper dicDao; 

	@Override
	public ResultMsg insertDic(Dic dic) {
		ResultMsg result = new ResultMsg();
		try {
			dicDao.insertDic(dic);
			result.setSuccess(true);
			result.setResultMsg("记录已插入");
		}catch(Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMsg("插入记录出错");
			
		}
		return result;
	}

	@Override
	public List<Dic> findDicList(Dic dic) {
		List<Dic> findDicList = dicDao.findDicList(dic);
		return findDicList;
	}

	@Override
	public ResultMsg updateDic(Dic dic) {
		ResultMsg result = new ResultMsg();
		try {
			dicDao.updateDic(dic);
			result.setSuccess(true);
			result.setResultMsg("记录已插入");
		}catch(Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMsg("插入记录出错");
			
		}
		return result;
	}

	@Override
	public List<Dic> getGradeList() {
		List<Dic> gradeList = dicDao.getGradeList();
		
		return gradeList;
	}

}
