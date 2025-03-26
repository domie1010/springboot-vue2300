package com.dao;

import com.entity.KemuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KemuVO;
import com.entity.view.KemuView;


/**
 * 科目
 * 
 * @author 
 * @email 
 * @date 2024-04-06 21:14:09
 */
public interface KemuDao extends BaseMapper<KemuEntity> {
	
	List<KemuVO> selectListVO(@Param("ew") Wrapper<KemuEntity> wrapper);
	
	KemuVO selectVO(@Param("ew") Wrapper<KemuEntity> wrapper);
	
	List<KemuView> selectListView(@Param("ew") Wrapper<KemuEntity> wrapper);

	List<KemuView> selectListView(Pagination page,@Param("ew") Wrapper<KemuEntity> wrapper);

	
	KemuView selectView(@Param("ew") Wrapper<KemuEntity> wrapper);
	

}
