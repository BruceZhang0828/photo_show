package com.zhangran.photo_show.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-17 21:38:43
 */
@TableName("zr_category_image")
public class CategoryImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 分类id
	 */
	private Long categoryId;
	/**
	 * 图片url
	 */
	private String url;
	/**
	 * 上传人
	 */
	private Long uploadId;
	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：分类id
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：分类id
	 */
	public Long getCategoryId() {
		return categoryId;
	}
	/**
	 * 设置：图片url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：图片url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：上传人
	 */
	public void setUploadId(Long uploadId) {
		this.uploadId = uploadId;
	}
	/**
	 * 获取：上传人
	 */
	public Long getUploadId() {
		return uploadId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
