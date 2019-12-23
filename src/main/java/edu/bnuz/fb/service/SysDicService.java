package edu.bnuz.fb.service;

import java.util.List;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.entity.Dic;

public interface SysDicService {
	
	public ResultMsg insertDic(Dic dic);
	
	public List<Dic> findDicList(Dic dic);
	
	public ResultMsg updateDic(Dic dic);
	
	public List<Dic> getGradeList();
	
	

}
