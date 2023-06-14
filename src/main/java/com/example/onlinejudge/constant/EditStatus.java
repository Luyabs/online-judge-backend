package com.example.onlinejudge.constant;

/**
 * 审批状态
 */
public enum EditStatus implements EnumIndex {
    NULL("null"),
    WAIT("待审核"),
    VERIFIED("审核通过"),
    FAILED("审核失败");

    public final String status;

    EditStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static EditStatus get(int index) {
        return switch (index) {
            case 1 -> WAIT;
            case 2 -> VERIFIED;
            case 3 -> FAILED;
            default -> EditStatus.NULL;
        };
    }

    @Override
    public int index() {
        return switch (this) {
            case WAIT -> 1;
            case VERIFIED -> 2;
            case FAILED -> 3;
            default -> 0;
        };
    }
}
