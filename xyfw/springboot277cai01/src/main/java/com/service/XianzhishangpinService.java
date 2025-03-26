package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XianzhishangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XianzhishangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XianzhishangpinView;


/**
 * 闲置商品
 *
 * @author 
 * @email 
 * @date 2024-04-06 21:14:09
 */
public interface XianzhishangpinService extends IService<XianzhishangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XianzhishangpinVO> selectListVO(Wrapper<XianzhishangpinEntity> wrapper);
   	
   	XianzhishangpinVO selectVO(@Param("ew") Wrapper<XianzhishangpinEntity> wrapper);
   	
   	List<XianzhishangpinView> selectListView(Wrapper<XianzhishangpinEntity> wrapper);
   	
   	XianzhishangpinView selectView(@Param("ew") Wrapper<XianzhishangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XianzhishangpinEntity> wrapper);

   	

}

