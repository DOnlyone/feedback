package edu.bnuz.fb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bnuz.fb.entity.Dic;

@Mapper
public interface DicMapper {
	
	
	/**
	 * 新增一条记录
	 */
	public void insertDic(Dic dic);
	
	/**
	 * 通用查询方法
	 * @return
	 */
	public List<Dic> findDicList(Dic dic);
	
	/**
	 * 修改dic
	 * @param dic
	 */
	public void updateDic(Dic dic);
	
	/**
	 *根据字典id删除字典条目
	 * @param dic_id
	 */
	public void deleteDic(Long dic_id);
	
	

}
