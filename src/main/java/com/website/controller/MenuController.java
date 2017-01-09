package com.website.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 16/10/27.
 * 菜单管理
 */
@RequestMapping("/menu")
public class MenuController {

    /**
     * 菜单配置列表
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "menuIndex";
    }

}
