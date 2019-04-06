package com.zhangran.photo_show.vo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderVo {
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 金额
     */
    private BigDecimal price;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 团id
     */
    private Long clusterId;
    /**
     * 用户名称
     */
    private String userName;
    /*订单状态*/
    private int state;
    /*评价内容*/
    private String content;

    private String reply;

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
     * 设置：金额
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取：金额
     */
    public BigDecimal getPrice() {
        return price;
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

    /**
     * 设置：团id
     */
    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    /**
     * 获取：团id
     */
    public Long getClusterId() {
        return clusterId;
    }

    /**
     * 设置：用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取：用户名称
     */
    public String getUserName() {
        return userName;
    }

}
