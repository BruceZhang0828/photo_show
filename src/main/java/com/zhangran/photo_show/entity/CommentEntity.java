package com.zhangran.photo_show.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论表
 * 
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-02 16:01:34
 */
@TableName("zr_comment")
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 评价内容
	 */
	private String content;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 回复
	 */
	private String reply;
	/**
	 * 管理员id
	 */
	private Long sysUserId;
	/**
	 * 创建时间/处理时间
	 */
	private Date creatDate;
	/**
	 * 状态
	 */
	private String state;

	private int rate;

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

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
	 * 设置：评价内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：评价内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：回复
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}
	/**
	 * 获取：回复
	 */
	public String getReply() {
		return reply;
	}
	/**
	 * 设置：管理员id
	 */
	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}
	/**
	 * 获取：管理员id
	 */
	public Long getSysUserId() {
		return sysUserId;
	}
	/**
	 * 设置：创建时间/处理时间
	 */
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	/**
	 * 获取：创建时间/处理时间
	 */
	public Date getCreatDate() {
		return creatDate;
	}
	/**
	 * 设置：状态
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取：状态
	 */
	public String getState() {
		return state;
	}
}
