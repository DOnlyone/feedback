package edu.bnuz.fb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.entity.Dic;
import edu.bnuz.fb.service.SysDicService;

@Controller
public class DicController {
	
	
	@Autowired
	private SysDicService sysDicService;
	
	@RequestMapping("/dicHome")
	public String DicHome() {
		
		
		return "admin/dic_home";
	}
	
	@ResponseBody
	@RequestMapping("/add_Dic")
	public ResultMsg addDic(Dic dic) {
		System.out.println(dic);
		ResultMsg result = sysDicService.insertDic(dic);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("findDics")
	public ResultMsg findDicList(Dic dic) {
		ResultMsg result = new ResultMsg();
		List<Dic> findDicList = sysDicService.findDicList(dic);
		if(findDicList==null&&findDicList.size()<=0) {
			result.setSuccess(false);
			result.setResultMsg("没有找到相关记录");
			return result;
		}
		result.setTotal(findDicList.size());
		result.setSuccess(true);
		result.setRows(findDicList);
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("updateDic")
	public ResultMsg updateDic(Dic dic) {
		ResultMsg result = sysDicService.updateDic(dic);
		return result;
	}

}
