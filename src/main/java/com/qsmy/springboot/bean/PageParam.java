package com.qsmy.springboot.bean;

import lombok.Data;

/**
 * @author qsmy
 * @date 2019-04-11 16:17
 */
@Data
public class PageParam {
    /**
     * 起始行
     */
    private int beginLine;
    private Integer pageSize = 3;
    /**
     * 当前页
     */
    private Integer currentPage = 0;
}
