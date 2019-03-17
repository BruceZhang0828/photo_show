package com.zhangran.photo_show.utils;

public class PageResponse extends Response {

    public PageResponse(String code, String msg) {
        super(code, msg);
    }

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
