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


import com.dao.DiscussxianzhishangpinDao;
import com.entity.DiscussxianzhishangpinEntity;
import com.service.DiscussxianzhishangpinService;
import com.entity.vo.DiscussxianzhishangpinVO;
import com.entity.view.DiscussxianzhishangpinView;

@Service("discussxianzhishangpinService")
public class DiscussxianzhishangpinServiceImpl extends ServiceImpl<DiscussxianzhishangpinDao, DiscussxianzhishangpinEntity> implements DiscussxianzhishangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxianzhishangpinEntity> page = this.selectPage(
                new Query<DiscussxianzhishangpinEntity>(params).getPage(),
                new EntityWrapper<DiscussxianzhishangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxianzhishangpinEntity> wrapper) {
		  Page<DiscussxianzhishangpinView> page =new Query<DiscussxianzhishangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussxianzhishangpinVO> selectListVO(Wrapper<DiscussxianzhishangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxianzhishangpinVO selectVO(Wrapper<DiscussxianzhishangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxianzhishangpinView> selectListView(Wrapper<DiscussxianzhishangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxianzhishangpinView selectView(Wrapper<DiscussxianzhishangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
