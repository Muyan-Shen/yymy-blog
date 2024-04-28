package com.cystrix.blog.entity;

import com.cystrix.blog.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author chenyue7@foxmail.com
 * @date 28/12/2023
 * @description
 */
@Getter
@Setter
public class Motto extends BaseEntity {
    private Integer id;
    private String content;
}
