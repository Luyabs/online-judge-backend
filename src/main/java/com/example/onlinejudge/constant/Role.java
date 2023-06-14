package com.example.onlinejudge.constant;

/**
 * 角色
 */
public enum Role implements EnumIndex {
    NULL("null"),
    NORMAL_USER("normal_user"),
    ADMIN("admin");

    public final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public static Role get(int index) {
        return switch (index) {
            case 1 -> NORMAL_USER;
            case 2 -> ADMIN;
            default -> NULL;
        };
    }

    @Override
    public int index() {
        return switch (this) {
            case NORMAL_USER -> 1;
            case ADMIN -> 2;
            default -> 0;
        };
    }
}
