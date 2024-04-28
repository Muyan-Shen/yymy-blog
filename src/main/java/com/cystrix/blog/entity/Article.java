package com.cystrix.blog.entity;

import com.cystrix.blog.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: chenyue7@foxmail.com
 * @date: 10/7/2023
 * @description:
 */
@Getter
@Setter
public class Article extends BaseEntity {
    private Integer id;
    private String title;
    private Integer coverId;
    private String content;
    private String digest;
    private Integer wordNum;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private Integer hotRank;

    // non-db field
    private String categoryName;
    private Integer categoryId;
    private String coverImg;
}
