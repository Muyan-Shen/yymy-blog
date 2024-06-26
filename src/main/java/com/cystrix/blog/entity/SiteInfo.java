package com.cystrix.blog.entity;

import com.cystrix.blog.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author chenyue7@foxmail.com
 * @date 20/12/2023
 * @description
 */
@Data
public class SiteInfo extends BaseEntity {
    private Integer id;
    private Integer articleNum;
    private Integer runDays;
    private Integer wordsNum;
    private Integer visitorsNum;
    private Integer visitNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime latestUpdateTime;
}
