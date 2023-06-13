package com.example.onlinejudge.constant;

/**
 * 角色
 */
public enum Role {
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

    public static Role getRole(int index) {
        return switch (index) {
            case 1 -> Role.NORMAL_USER;
            case 2 -> Role.ADMIN;
            default -> Role.NULL;
        };
    }

    public static int getIndex(Role role) {
        return switch (role) {
            case NORMAL_USER -> 1;
            case ADMIN -> 2;
            default -> 0;
        };
    }


}
