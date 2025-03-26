package com.dao;

import com.entity.DiscussxianzhishangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxianzhishangpinVO;
import com.entity.view.DiscussxianzhishangpinView;


/**
 * 闲置商品评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-06 21:14:10
 */
public interface DiscussxianzhishangpinDao extends BaseMapper<DiscussxianzhishangpinEntity> {
	
	List<DiscussxianzhishangpinVO> selectListVO(@Param("ew") Wrapper<DiscussxianzhishangpinEntity> wrapper);
	
	DiscussxianzhishangpinVO selectVO(@Param("ew") Wrapper<DiscussxianzhishangpinEntity> wrapper);
	
	List<DiscussxianzhishangpinView> selectListView(@Param("ew") Wrapper<DiscussxianzhishangpinEntity> wrapper);

	List<DiscussxianzhishangpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxianzhishangpinEntity> wrapper);

	
	DiscussxianzhishangpinView selectView(@Param("ew") Wrapper<DiscussxianzhishangpinEntity> wrapper);
	

}
