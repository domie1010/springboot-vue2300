package com.entity.view;

import com.entity.DiscussshiwuzhaolingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 失物招领评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-06 21:14:10
 */
@TableName("discussshiwuzhaoling")
public class DiscussshiwuzhaolingView  extends DiscussshiwuzhaolingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussshiwuzhaolingView(){
	}
 
 	public DiscussshiwuzhaolingView(DiscussshiwuzhaolingEntity discussshiwuzhaolingEntity){
 	try {
			BeanUtils.copyProperties(this, discussshiwuzhaolingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
