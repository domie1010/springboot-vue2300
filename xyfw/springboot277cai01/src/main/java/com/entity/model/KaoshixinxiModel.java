package com.entity.model;

import com.entity.KaoshixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 考试信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-06 21:14:09
 */
public class KaoshixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 科目
	 */
	
	private String kemu;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 考试日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date kaoshiriqi;
		
	/**
	 * 考试时间
	 */
	
	private String kaoshishijian;
		
	/**
	 * 考试场地
	 */
	
	private String kaoshichangdi;
		
	/**
	 * 考试须知
	 */
	
	private String kaoshixuzhi;
				
	
	/**
	 * 设置：科目
	 */
	 
	public void setKemu(String kemu) {
		this.kemu = kemu;
	}
	
	/**
	 * 获取：科目
	 */
	public String getKemu() {
		return kemu;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：考试日期
	 */
	 
	public void setKaoshiriqi(Date kaoshiriqi) {
		this.kaoshiriqi = kaoshiriqi;
	}
	
	/**
	 * 获取：考试日期
	 */
	public Date getKaoshiriqi() {
		return kaoshiriqi;
	}
				
	
	/**
	 * 设置：考试时间
	 */
	 
	public void setKaoshishijian(String kaoshishijian) {
		this.kaoshishijian = kaoshishijian;
	}
	
	/**
	 * 获取：考试时间
	 */
	public String getKaoshishijian() {
		return kaoshishijian;
	}
				
	
	/**
	 * 设置：考试场地
	 */
	 
	public void setKaoshichangdi(String kaoshichangdi) {
		this.kaoshichangdi = kaoshichangdi;
	}
	
	/**
	 * 获取：考试场地
	 */
	public String getKaoshichangdi() {
		return kaoshichangdi;
	}
				
	
	/**
	 * 设置：考试须知
	 */
	 
	public void setKaoshixuzhi(String kaoshixuzhi) {
		this.kaoshixuzhi = kaoshixuzhi;
	}
	
	/**
	 * 获取：考试须知
	 */
	public String getKaoshixuzhi() {
		return kaoshixuzhi;
	}
			
}
