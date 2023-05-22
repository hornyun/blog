package com.hornyun.blog.service;

import com.hornyun.blog.entity.Menu;
import com.hornyun.blog.util.UUIDUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class IMenuServiceTest {
    @Resource
    private IMenuService menuService;

    @Test
    void saveMenu() {
        Menu menu = new Menu();
        menu.setMenuName("测试");
        menu.setId(UUIDUtils.generate());
        menu.setImg("/img/test");
        boolean save = menuService.save(menu);
        Assertions.assertTrue(save);
    }
}
