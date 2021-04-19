package com.bamboo.commerce.product.entity;

import com.bamboo.common.valid.AddGroup;
import com.bamboo.common.valid.ListValues;
import com.bamboo.common.valid.UpdateGroup;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 15:09:54
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@Null(message = "新增必须为空", groups = {AddGroup.class})
	@NotNull(message = "修改不能为空", groups = {UpdateGroup.class})
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */

	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@ListValues(values = {0, 1}, groups = {AddGroup.class, UpdateGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是英文字母", groups = {AddGroup.class, UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@Min(value = 0, message = "最小值为0", groups = {AddGroup.class, UpdateGroup.class})
	private Integer sort;

}
