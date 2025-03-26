package com.entity.view;

import com.entity.DiscussxianzhishangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 闲置商品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-06 21:14:10
 */
@TableName("discussxianzhishangpin")
public class DiscussxianzhishangpinView  extends DiscussxianzhishangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxianzhishangpinView(){
	}
 
 	public DiscussxianzhishangpinView(DiscussxianzhishangpinEntity discussxianzhishangpinEntity){
 	try {
			BeanUtils.copyProperties(this, discussxianzhishangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
