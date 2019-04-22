package com.zgx.bootdemo.entity;

import java.util.List;

/**
 * @author zhouguixing
 * @date 2019/4/18 9:17
 * @description 分页
 */
public class Page<T> {
    private Integer offset;//起始码
    private Integer limit;//记录数
    private Long totalSize;//总记录数
    private List<T> list;//列表
    private String orderKey;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }
}
