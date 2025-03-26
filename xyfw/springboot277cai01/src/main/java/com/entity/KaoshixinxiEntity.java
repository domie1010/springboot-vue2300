package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 考试信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-06 21:14:09
 */
@TableName("kaoshixinxi")
public class KaoshixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KaoshixinxiEntity() {
		
	}
	
	public KaoshixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 考试名称
	 */
					
	private String kaoshimingcheng;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：考试名称
	 */
	public void setKaoshimingcheng(String kaoshimingcheng) {
		this.kaoshimingcheng = kaoshimingcheng;
	}
	/**
	 * 获取：考试名称
	 */
	public String getKaoshimingcheng() {
		return kaoshimingcheng;
	}
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
