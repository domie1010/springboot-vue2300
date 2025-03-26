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


import com.dao.XianzhishangpinDao;
import com.entity.XianzhishangpinEntity;
import com.service.XianzhishangpinService;
import com.entity.vo.XianzhishangpinVO;
import com.entity.view.XianzhishangpinView;

@Service("xianzhishangpinService")
public class XianzhishangpinServiceImpl extends ServiceImpl<XianzhishangpinDao, XianzhishangpinEntity> implements XianzhishangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XianzhishangpinEntity> page = this.selectPage(
                new Query<XianzhishangpinEntity>(params).getPage(),
                new EntityWrapper<XianzhishangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XianzhishangpinEntity> wrapper) {
		  Page<XianzhishangpinView> page =new Query<XianzhishangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XianzhishangpinVO> selectListVO(Wrapper<XianzhishangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XianzhishangpinVO selectVO(Wrapper<XianzhishangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XianzhishangpinView> selectListView(Wrapper<XianzhishangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XianzhishangpinView selectView(Wrapper<XianzhishangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
