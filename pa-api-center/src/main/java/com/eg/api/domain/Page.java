package com.eg.api.domain;

import java.io.Serializable;

/**
 * Page对象.<br>
 * 提供给外部系统的分页Bean<br>
 *
 * @param <T>
 *            结果集的数据类型 Date: 2017年2月22日 <br>
 *            Copyright (c) 2017 asiainfo.com <br>
 * @author gucl
 */
public class Page implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 请求查询的页码
     */
    private int pageNum = 1;

    /**
     * 每页显示条数
     */
    private int pageSize = 10;

    private long count = 0;
    private long pageCount;

    Page(Page p) {
        this.pageNum = p.pageNum;
        this.pageSize = p.pageSize;
        this.pageCount = p.pageCount;
        this.count = p.count;
    }

    public Page() {
        super();
    }

    public Page(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public int getStartRowIndex() {
        return (this.getPageNum() - 1) * this.getPageSize() + 1;
    }

    public int getEndRowIndex() {
        return this.getPageNum() * this.getPageSize();
    }

    public long getPageCount() {
        long quotient = this.getCount() / this.getPageNum();
        long remainder = this.getCount() % this.getPageNum();
        this.pageCount = quotient;
        if (remainder > 0) {
            ++this.pageCount;
        }

        return this.pageCount;
    }


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
