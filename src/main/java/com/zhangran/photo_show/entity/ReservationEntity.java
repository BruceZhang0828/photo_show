package com.zhangran.photo_show.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-02 12:44:54
 */
@TableName("zr_reservation")
public class ReservationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 预约手机
	 */
	private String mobile;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 管理员id
	 */
	private Long sUserId;
	/**
	 * 预约日期
	 */
	private Date reservationDate;
	/**
	 * 创建日期
	 */
	private Date creatDate;
	/**
	 * 状态
	 */
	private Integer state;
	/**
	 * 定金
	 */
	private BigDecimal earnestMoney;

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
	 * 设置：预约手机
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：预约手机
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
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
	 * 设置：管理员id
	 */
	public void setSUserId(Long sUserId) {
		this.sUserId = sUserId;
	}
	/**
	 * 获取：管理员id
	 */
	public Long getSUserId() {
		return sUserId;
	}
	/**
	 * 设置：预约日期
	 */
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	/**
	 * 获取：预约日期
	 */
	public Date getReservationDate() {
		return reservationDate;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreatDate() {
		return creatDate;
	}
	/**
	 * 设置：状态
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：状态
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：定金
	 */
	public void setEarnestMoney(BigDecimal earnestMoney) {
		this.earnestMoney = earnestMoney;
	}
	/**
	 * 获取：定金
	 */
	public BigDecimal getEarnestMoney() {
		return earnestMoney;
	}
}
