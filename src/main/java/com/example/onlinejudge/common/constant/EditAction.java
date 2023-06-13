package com.example.onlinejudge.common.constant;

/**
 * 题目修改动作
 */
public enum EditAction {
    NULL("null"),
    INSERT("新增"),
    DELETE("删除"),
    UPDATE("修改");

    public final String action;

    EditAction(String action) {
        this.action = action;
    }

    public String getRoleName() {
        return action;
    }

    public static EditAction getEditAction(int index) {
        return switch (index) {
            case 1 -> EditAction.INSERT;
            case 2 -> EditAction.DELETE;
            case 3 -> EditAction.UPDATE;
            default -> EditAction.NULL;
        };
    }

    public static int getIndex(EditAction type) {
        return switch (type) {
            case INSERT -> 1;
            case DELETE -> 2;
            case UPDATE -> 3;
            default -> 0;
        };
    }
}
