package com.zgx.bootdemo.entity;

import java.util.List;

/**
 * @author zhouguixing
 * @date 2019/4/18 9:17
 * @description 分页
 */
public class Page<T> {
    private Integer pageNum;//页码
    private Integer pageSize;//页面大小
    private Long totalSize;//总记录数
    private List<T> list;//列表

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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
}
