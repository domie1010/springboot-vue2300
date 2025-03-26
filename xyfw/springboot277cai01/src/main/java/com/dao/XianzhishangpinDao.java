package com.dao;

import com.entity.XianzhishangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XianzhishangpinVO;
import com.entity.view.XianzhishangpinView;


/**
 * 闲置商品
 * 
 * @author 
 * @email 
 * @date 2024-04-06 21:14:09
 */
public interface XianzhishangpinDao extends BaseMapper<XianzhishangpinEntity> {
	
	List<XianzhishangpinVO> selectListVO(@Param("ew") Wrapper<XianzhishangpinEntity> wrapper);
	
	XianzhishangpinVO selectVO(@Param("ew") Wrapper<XianzhishangpinEntity> wrapper);
	
	List<XianzhishangpinView> selectListView(@Param("ew") Wrapper<XianzhishangpinEntity> wrapper);

	List<XianzhishangpinView> selectListView(Pagination page,@Param("ew") Wrapper<XianzhishangpinEntity> wrapper);

	
	XianzhishangpinView selectView(@Param("ew") Wrapper<XianzhishangpinEntity> wrapper);
	

}
