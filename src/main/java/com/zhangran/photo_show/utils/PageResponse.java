package com.zhangran.photo_show.utils;

public class PageResponse extends Response {

    public PageResponse(String code, String msg) {
        super(code, msg);
    }

    private int totalCount;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
