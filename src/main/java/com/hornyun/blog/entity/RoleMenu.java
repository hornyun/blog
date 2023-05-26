package com.hornyun.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色与菜单对应关系
 * </p>
 *
 * @author HornYun
 * @since 2023-05-25
 */
@TableName("t_blog_role_menu")
@ApiModel(value = "RoleMenu对象", description = "角色与菜单对应关系")
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty("角色ID")
    private String roleId;

    @ApiModelProperty("菜单ID")
    private String menuId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
        "id = " + id +
        ", roleId = " + roleId +
        ", menuId = " + menuId +
        "}";
    }
}
