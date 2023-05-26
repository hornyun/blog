package com.hornyun.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 博客系统菜单管理
 * </p>
 *
 * @author HornYun
 * @since 2023-05-24
 */
@TableName("t_blog_menu")
@ApiModel(value = "Menu对象", description = "博客系统菜单管理")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty("父菜单ID，一级菜单为0")
    private String parentId;

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("菜单URL")
    private String url;

    @ApiModelProperty("授权(多个用逗号分隔，如：user:list,user:create)")
    private String permission;

    @ApiModelProperty("类型   0：目录   1：菜单   2：按钮")
    private String type;

    @ApiModelProperty("菜单图标")
    private String icon;

    @ApiModelProperty("排序")
    private Integer orderNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Menu{" +
        "id = " + id +
        ", parentId = " + parentId +
        ", name = " + name +
        ", url = " + url +
        ", permission = " + permission +
        ", type = " + type +
        ", icon = " + icon +
        ", orderNum = " + orderNum +
        "}";
    }
}
