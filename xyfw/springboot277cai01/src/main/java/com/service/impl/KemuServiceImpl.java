package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KemuDao;
import com.entity.KemuEntity;
import com.service.KemuService;
import com.entity.vo.KemuVO;
import com.entity.view.KemuView;

@Service("kemuService")
public class KemuServiceImpl extends ServiceImpl<KemuDao, KemuEntity> implements KemuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KemuEntity> page = this.selectPage(
                new Query<KemuEntity>(params).getPage(),
                new EntityWrapper<KemuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KemuEntity> wrapper) {
		  Page<KemuView> page =new Query<KemuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KemuVO> selectListVO(Wrapper<KemuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KemuVO selectVO(Wrapper<KemuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KemuView> selectListView(Wrapper<KemuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KemuView selectView(Wrapper<KemuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
