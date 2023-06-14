package com.example.onlinejudge.constant;

/**
 * 题目修改动作
 */
public enum EditAction implements EnumIndex {
    NULL("null"),
    INSERT("新增"),
    DELETE("删除"),
    UPDATE("修改");

    public final String action;

    EditAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public static EditAction get(int index) {
        return switch (index) {
            case 1 -> INSERT;
            case 2 -> DELETE;
            case 3 -> UPDATE;
            default -> EditAction.NULL;
        };
    }

    @Override
    public int index() {
        return switch (this) {
            case INSERT -> 1;
            case DELETE -> 2;
            case UPDATE -> 3;
            default -> 0;
        };
    }
}
