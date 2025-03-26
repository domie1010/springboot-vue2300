package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxianzhishangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxianzhishangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxianzhishangpinView;


/**
 * 闲置商品评论表
 *
 * @author 
 * @email 
 * @date 2024-04-06 21:14:10
 */
public interface DiscussxianzhishangpinService extends IService<DiscussxianzhishangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxianzhishangpinVO> selectListVO(Wrapper<DiscussxianzhishangpinEntity> wrapper);
   	
   	DiscussxianzhishangpinVO selectVO(@Param("ew") Wrapper<DiscussxianzhishangpinEntity> wrapper);
   	
   	List<DiscussxianzhishangpinView> selectListView(Wrapper<DiscussxianzhishangpinEntity> wrapper);
   	
   	DiscussxianzhishangpinView selectView(@Param("ew") Wrapper<DiscussxianzhishangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxianzhishangpinEntity> wrapper);

   	

}

