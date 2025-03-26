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

import com.entity.XianzhishangpinEntity;
import com.entity.view.XianzhishangpinView;

import com.service.XianzhishangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 闲置商品
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 21:14:09
 */
@RestController
@RequestMapping("/xianzhishangpin")
public class XianzhishangpinController {
    @Autowired
    private XianzhishangpinService xianzhishangpinService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XianzhishangpinEntity xianzhishangpin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xianzhishangpin.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XianzhishangpinEntity> ew = new EntityWrapper<XianzhishangpinEntity>();

		PageUtils page = xianzhishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianzhishangpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XianzhishangpinEntity xianzhishangpin, 
		HttpServletRequest request){
        EntityWrapper<XianzhishangpinEntity> ew = new EntityWrapper<XianzhishangpinEntity>();

		PageUtils page = xianzhishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianzhishangpin), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XianzhishangpinEntity xianzhishangpin){
       	EntityWrapper<XianzhishangpinEntity> ew = new EntityWrapper<XianzhishangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xianzhishangpin, "xianzhishangpin")); 
        return R.ok().put("data", xianzhishangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XianzhishangpinEntity xianzhishangpin){
        EntityWrapper< XianzhishangpinEntity> ew = new EntityWrapper< XianzhishangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xianzhishangpin, "xianzhishangpin")); 
		XianzhishangpinView xianzhishangpinView =  xianzhishangpinService.selectView(ew);
		return R.ok("查询闲置商品成功").put("data", xianzhishangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XianzhishangpinEntity xianzhishangpin = xianzhishangpinService.selectById(id);
		xianzhishangpin.setClicktime(new Date());
		xianzhishangpinService.updateById(xianzhishangpin);
        xianzhishangpin = xianzhishangpinService.selectView(new EntityWrapper<XianzhishangpinEntity>().eq("id", id));
        return R.ok().put("data", xianzhishangpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XianzhishangpinEntity xianzhishangpin = xianzhishangpinService.selectById(id);
		xianzhishangpin.setClicktime(new Date());
		xianzhishangpinService.updateById(xianzhishangpin);
        xianzhishangpin = xianzhishangpinService.selectView(new EntityWrapper<XianzhishangpinEntity>().eq("id", id));
        return R.ok().put("data", xianzhishangpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XianzhishangpinEntity xianzhishangpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xianzhishangpin);
        xianzhishangpinService.insert(xianzhishangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XianzhishangpinEntity xianzhishangpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xianzhishangpin);
        xianzhishangpinService.insert(xianzhishangpin);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XianzhishangpinEntity xianzhishangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xianzhishangpin);
        xianzhishangpinService.updateById(xianzhishangpin);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XianzhishangpinEntity> list = new ArrayList<XianzhishangpinEntity>();
        for(Long id : ids) {
            XianzhishangpinEntity xianzhishangpin = xianzhishangpinService.selectById(id);
            xianzhishangpin.setSfsh(sfsh);
            xianzhishangpin.setShhf(shhf);
            list.add(xianzhishangpin);
        }
        xianzhishangpinService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xianzhishangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,XianzhishangpinEntity xianzhishangpin, HttpServletRequest request,String pre){
        EntityWrapper<XianzhishangpinEntity> ew = new EntityWrapper<XianzhishangpinEntity>();
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
		PageUtils page = xianzhishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianzhishangpin), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,XianzhishangpinEntity xianzhishangpin, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "shangpinfenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "xianzhishangpin").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<XianzhishangpinEntity> xianzhishangpinList = new ArrayList<XianzhishangpinEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                xianzhishangpinList.addAll(xianzhishangpinService.selectList(new EntityWrapper<XianzhishangpinEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<XianzhishangpinEntity> ew = new EntityWrapper<XianzhishangpinEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = xianzhishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianzhishangpin), params), params));
        List<XianzhishangpinEntity> pageList = (List<XianzhishangpinEntity>)page.getList();
        if(xianzhishangpinList.size()<limit) {
            int toAddNum = (limit-xianzhishangpinList.size())<=pageList.size()?(limit-xianzhishangpinList.size()):pageList.size();
            for(XianzhishangpinEntity o1 : pageList) {
                boolean addFlag = true;
                for(XianzhishangpinEntity o2 : xianzhishangpinList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    xianzhishangpinList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(xianzhishangpinList.size()>limit) {
            xianzhishangpinList = xianzhishangpinList.subList(0, limit);
        }
        page.setList(xianzhishangpinList);
        return R.ok().put("data", page);
    }








}
