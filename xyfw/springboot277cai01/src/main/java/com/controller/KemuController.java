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

import com.entity.KemuEntity;
import com.entity.view.KemuView;

import com.service.KemuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 科目
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 21:14:09
 */
@RestController
@RequestMapping("/kemu")
public class KemuController {
    @Autowired
    private KemuService kemuService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KemuEntity kemu,
		HttpServletRequest request){
        EntityWrapper<KemuEntity> ew = new EntityWrapper<KemuEntity>();

		PageUtils page = kemuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kemu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KemuEntity kemu, 
		HttpServletRequest request){
        EntityWrapper<KemuEntity> ew = new EntityWrapper<KemuEntity>();

		PageUtils page = kemuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kemu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KemuEntity kemu){
       	EntityWrapper<KemuEntity> ew = new EntityWrapper<KemuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kemu, "kemu")); 
        return R.ok().put("data", kemuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KemuEntity kemu){
        EntityWrapper< KemuEntity> ew = new EntityWrapper< KemuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kemu, "kemu")); 
		KemuView kemuView =  kemuService.selectView(ew);
		return R.ok("查询科目成功").put("data", kemuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KemuEntity kemu = kemuService.selectById(id);
        return R.ok().put("data", kemu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KemuEntity kemu = kemuService.selectById(id);
        return R.ok().put("data", kemu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KemuEntity kemu, HttpServletRequest request){
        if(kemuService.selectCount(new EntityWrapper<KemuEntity>().eq("kemu", kemu.getKemu()))>0) {
            return R.error("科目已存在");
        }
    	//ValidatorUtils.validateEntity(kemu);
        kemuService.insert(kemu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KemuEntity kemu, HttpServletRequest request){
        if(kemuService.selectCount(new EntityWrapper<KemuEntity>().eq("kemu", kemu.getKemu()))>0) {
            return R.error("科目已存在");
        }
    	//ValidatorUtils.validateEntity(kemu);
        kemuService.insert(kemu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KemuEntity kemu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kemu);
        if(kemuService.selectCount(new EntityWrapper<KemuEntity>().ne("id", kemu.getId()).eq("kemu", kemu.getKemu()))>0) {
            return R.error("科目已存在");
        }
        kemuService.updateById(kemu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kemuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
