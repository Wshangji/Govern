package com.govern.webservie.util;

import lombok.Data;

import java.util.List;

/**
 * @author: Nanf_bunan
 * @date: 2021-12-26 23-13
 */
@Data
public class PageResult<T> extends Result{
    //总记录数
    private long total;
    //分页数量
    private List<T> rows;

    public PageResult(long total, List<T> rows) {
        this.setFlag(true);
        this.setMsg("分页查询成功");
        this.total = total;
        this.rows = rows;
    }
}
