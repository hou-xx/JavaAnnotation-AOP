package com.hxx.enums;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2018/8/29 0029 17:23 </li>
 * <li>邮箱：hou_xiangxiang@126.com</li>
 * </ul>
 */

public enum UserType {
    SYSTEM_ADMIN("系统管理员"),
    TOURISTS("游客");
    private String description;

    UserType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name() + " - " + this.getDescription();
    }
}
