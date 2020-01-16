package edu.bnuz.fb.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import edu.bnuz.fb.common.ResultMsg;
import edu.bnuz.fb.entity.Content;
import edu.bnuz.fb.entity.WfDef;
import edu.bnuz.fb.mapper.ContentMapper;
import edu.bnuz.fb.mapper.WfDefMapper;
import edu.bnuz.fb.rbac.entity.Authority;
import edu.bnuz.fb.rbac.entity.Role;
import edu.bnuz.fb.rbac.entity.User;
import edu.bnuz.fb.rbac.service.UserService;
import edu.bnuz.fb.service.ContentService;


@Service
public class ContentServiceImpl implements ContentService {
	
	
	@Autowired
	private ContentMapper contentDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private WfDefMapper wfDefDao;


	@Override
	public ResultMsg addContent(Content content) {
		ResultMsg msg = new ResultMsg();
		try {
			Long contentId = contentDao.insert(content);
			msg.setEntityId(contentId);
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

	@Override
	public ResultMsg getContentDetail(Map param) {
		ResultMsg msg = new ResultMsg();
		List contentDetail = contentDao.getContentDetail(param);
		if(contentDetail!=null&&contentDetail.size()>0) {
			msg.setSuccess(true);
			msg.setRows(contentDetail);
			return msg;
		}
		msg.setSuccess(false);
		msg.setResultMsg("没有找到相关记录");
		return msg;
	}

	@Override
	public ResultMsg getContentbyType(Map param) {
		ResultMsg msg = new ResultMsg();
		List contentDetail = contentDao.getContentbyType(param);
		if(contentDetail!=null&&contentDetail.size()>0) {
			msg.setSuccess(true);
			msg.setRows(contentDetail);
			return msg;
		}
		msg.setSuccess(false);
		msg.setResultMsg("没有找到相关记录");
		return msg;
	}
	
	/**
	 * 1、根据用户ID获取当前用户的角色、以及权限（管理哪些班级的文档）
	 * 2、根据角色名获取该用户角色可办理的文档
	 */
	@Override
	public ResultMsg getContentListByUserpermission(Map param) {
		ResultMsg msg = new ResultMsg();
		
		User userInfo = userService.getUserInfo(param);
		//查看当前用户下作用域下的班级
		List<Authority> authList = new ArrayList();
		List<String> roleList = new ArrayList();
		userInfo.getRoleList().parallelStream().forEach(role->{
			authList.addAll(role.getAuthList());
			roleList.add(role.getRoleName());
		});
		List<Long> scopeList = authList.stream().map(Authority::getScope).collect(Collectors.toList());
		//查询角色可查处理的节点
		List<String> wfDefListByRole = wfDefDao.getWfDefListByRole(roleList);
		String userRoles = wfDefListByRole.stream().collect(Collectors.joining(","));
		//构造查询条件的param

		param.put("scopeList",scopeList);
		param.put("roleListStr",userRoles);
		//查询
		List queryContentByProcessRole = contentDao.queryContentByProcessRole(param);
		if(queryContentByProcessRole!=null&&queryContentByProcessRole.size()>0) {
			msg.setSuccess(true);
			msg.setRows(queryContentByProcessRole);
			return msg;
		}
		msg.setSuccess(true);
		msg.setResultMsg("没有查询到匹配的结果");

		return msg;
	}
	
	

}
