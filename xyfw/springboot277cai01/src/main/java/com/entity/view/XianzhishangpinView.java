package com.entity.view;

import com.entity.XianzhishangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 闲置商品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-06 21:14:09
 */
@TableName("xianzhishangpin")
public class XianzhishangpinView  extends XianzhishangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XianzhishangpinView(){
	}
 
 	public XianzhishangpinView(XianzhishangpinEntity xianzhishangpinEntity){
 	try {
			BeanUtils.copyProperties(this, xianzhishangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
