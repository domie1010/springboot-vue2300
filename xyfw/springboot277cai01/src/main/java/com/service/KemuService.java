package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KemuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KemuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KemuView;


/**
 * 科目
 *
 * @author 
 * @email 
 * @date 2024-04-06 21:14:09
 */
public interface KemuService extends IService<KemuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KemuVO> selectListVO(Wrapper<KemuEntity> wrapper);
   	
   	KemuVO selectVO(@Param("ew") Wrapper<KemuEntity> wrapper);
   	
   	List<KemuView> selectListView(Wrapper<KemuEntity> wrapper);
   	
   	KemuView selectView(@Param("ew") Wrapper<KemuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KemuEntity> wrapper);

   	

}

