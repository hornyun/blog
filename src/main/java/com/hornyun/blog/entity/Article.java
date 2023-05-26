package com.hornyun.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 博客文章表
 * </p>
 *
 * @author HornYun
 * @since 2023-05-24
 */
@TableName("t_blog_article")
@ApiModel(value = "Article对象", description = "博客文章表")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty("文章标题")
    private String articleTitle;

    @ApiModelProperty("文章封面")
    private String articleCover;

    @ApiModelProperty("文章内容")
    private String articleContent;

    @ApiModelProperty("文章简介")
    private String articleIntroduction;

    @ApiModelProperty("作者id")
    private String userId;

    @ApiModelProperty("文章状态 0=正常，1=废弃")
    private String state;

    @ApiModelProperty("文章排序")
    private Integer articleOrder;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleIntroduction() {
        return articleIntroduction;
    }

    public void setArticleIntroduction(String articleIntroduction) {
        this.articleIntroduction = articleIntroduction;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getArticleOrder() {
        return articleOrder;
    }

    public void setArticleOrder(Integer articleOrder) {
        this.articleOrder = articleOrder;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Article{" +
        "id = " + id +
        ", articleTitle = " + articleTitle +
        ", articleCover = " + articleCover +
        ", articleContent = " + articleContent +
        ", articleIntroduction = " + articleIntroduction +
        ", userId = " + userId +
        ", state = " + state +
        ", articleOrder = " + articleOrder +
        ", createTime = " + createTime +
        ", updateTime = " + updateTime +
        "}";
    }
}
