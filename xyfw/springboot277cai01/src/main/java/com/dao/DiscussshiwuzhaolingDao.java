package com.dao;

import com.entity.DiscussshiwuzhaolingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshiwuzhaolingVO;
import com.entity.view.DiscussshiwuzhaolingView;


/**
 * 失物招领评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-06 21:14:10
 */
public interface DiscussshiwuzhaolingDao extends BaseMapper<DiscussshiwuzhaolingEntity> {
	
	List<DiscussshiwuzhaolingVO> selectListVO(@Param("ew") Wrapper<DiscussshiwuzhaolingEntity> wrapper);
	
	DiscussshiwuzhaolingVO selectVO(@Param("ew") Wrapper<DiscussshiwuzhaolingEntity> wrapper);
	
	List<DiscussshiwuzhaolingView> selectListView(@Param("ew") Wrapper<DiscussshiwuzhaolingEntity> wrapper);

	List<DiscussshiwuzhaolingView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshiwuzhaolingEntity> wrapper);

	
	DiscussshiwuzhaolingView selectView(@Param("ew") Wrapper<DiscussshiwuzhaolingEntity> wrapper);
	

}
