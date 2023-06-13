package com.example.onlinejudge.common.constant;

/**
 * 审批状态
 */
public enum EditStatus {
    NULL("null"),
    WAIT("待审核"),
    VERIFIED("审核通过"),
    FAILED("审核失败");

    public final String status;

    EditStatus(String status) {
        this.status = status;
    }

    public String getRoleName() {
        return status;
    }

    public static EditStatus getEditStatus(int index) {
        return switch (index) {
            case 1 -> EditStatus.WAIT;
            case 2 -> EditStatus.VERIFIED;
            case 3 -> EditStatus.FAILED;
            default -> EditStatus.NULL;
        };
    }

    public static int getIndex(EditStatus type) {
        return switch (type) {
            case WAIT -> 1;
            case VERIFIED -> 2;
            case FAILED -> 3;
            default -> 0;
        };
    }
}
