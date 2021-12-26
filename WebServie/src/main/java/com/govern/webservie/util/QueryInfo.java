package com.govern.webservie.util;

import lombok.Data;

/**
 * @author: Nanf_bunan
 * @date: 2021-12-26 23-17
 */
@Data
public class QueryInfo {
    //第几页
    private Integer pageNumber;
    //一页多少条数据
    private Integer pageSize;
    //查询内容
    private String queryString;
}
