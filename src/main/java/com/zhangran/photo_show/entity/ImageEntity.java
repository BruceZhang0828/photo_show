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
 * @date 2019-03-08 21:09:45
 */
@TableName("zr_image")
public class ImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 图片地址
	 */
	private String url;
	/**
	 * 用户
	 */
	private Long userId;
	/**
	 * 上传者
	 */
	private Long uploadId;
	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：图片地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：图片地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：用户
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：上传者
	 */
	public void setUploadId(Long uploadId) {
		this.uploadId = uploadId;
	}
	/**
	 * 获取：上传者
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
