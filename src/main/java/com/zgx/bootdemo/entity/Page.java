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
    private Integer totalPage;//总页数
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

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
