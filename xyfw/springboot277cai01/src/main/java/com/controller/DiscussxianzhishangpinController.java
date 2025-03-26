package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussxianzhishangpinEntity;
import com.entity.view.DiscussxianzhishangpinView;

import com.service.DiscussxianzhishangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 闲置商品评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 21:14:10
 */
@RestController
@RequestMapping("/discussxianzhishangpin")
public class DiscussxianzhishangpinController {
    @Autowired
    private DiscussxianzhishangpinService discussxianzhishangpinService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxianzhishangpinEntity discussxianzhishangpin,
		HttpServletRequest request){
        EntityWrapper<DiscussxianzhishangpinEntity> ew = new EntityWrapper<DiscussxianzhishangpinEntity>();

		PageUtils page = discussxianzhishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxianzhishangpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxianzhishangpinEntity discussxianzhishangpin, 
		HttpServletRequest request){
        EntityWrapper<DiscussxianzhishangpinEntity> ew = new EntityWrapper<DiscussxianzhishangpinEntity>();

		PageUtils page = discussxianzhishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxianzhishangpin), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxianzhishangpinEntity discussxianzhishangpin){
       	EntityWrapper<DiscussxianzhishangpinEntity> ew = new EntityWrapper<DiscussxianzhishangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxianzhishangpin, "discussxianzhishangpin")); 
        return R.ok().put("data", discussxianzhishangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxianzhishangpinEntity discussxianzhishangpin){
        EntityWrapper< DiscussxianzhishangpinEntity> ew = new EntityWrapper< DiscussxianzhishangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxianzhishangpin, "discussxianzhishangpin")); 
		DiscussxianzhishangpinView discussxianzhishangpinView =  discussxianzhishangpinService.selectView(ew);
		return R.ok("查询闲置商品评论表成功").put("data", discussxianzhishangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxianzhishangpinEntity discussxianzhishangpin = discussxianzhishangpinService.selectById(id);
        return R.ok().put("data", discussxianzhishangpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxianzhishangpinEntity discussxianzhishangpin = discussxianzhishangpinService.selectById(id);
        return R.ok().put("data", discussxianzhishangpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxianzhishangpinEntity discussxianzhishangpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussxianzhishangpin);
        discussxianzhishangpinService.insert(discussxianzhishangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxianzhishangpinEntity discussxianzhishangpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussxianzhishangpin);
        discussxianzhishangpinService.insert(discussxianzhishangpin);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussxianzhishangpinEntity discussxianzhishangpin = discussxianzhishangpinService.selectOne(new EntityWrapper<DiscussxianzhishangpinEntity>().eq("", username));
        return R.ok().put("data", discussxianzhishangpin);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussxianzhishangpinEntity discussxianzhishangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxianzhishangpin);
        discussxianzhishangpinService.updateById(discussxianzhishangpin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxianzhishangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussxianzhishangpinEntity discussxianzhishangpin, HttpServletRequest request,String pre){
        EntityWrapper<DiscussxianzhishangpinEntity> ew = new EntityWrapper<DiscussxianzhishangpinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussxianzhishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxianzhishangpin), params), params));
        return R.ok().put("data", page);
    }










}
