package com.example.onlinejudge.constant;

/**
 * 题目类型
 */
public enum ProblemType {
    NULL("null"),
    SQL("SQL题"),
    PROGRAM("高级语言程序");

    public final String typeName;

    ProblemType(String typeName) {
        this.typeName = typeName;
    }

    public String getRoleName() {
        return typeName;
    }

    public static ProblemType getProblemType(int index) {
        return switch (index) {
            case 1 -> ProblemType.SQL;
            case 2 -> ProblemType.PROGRAM;
            default -> ProblemType.NULL;
        };
    }

    public static int getIndex(ProblemType type) {
        return switch (type) {
            case SQL -> 1;
            case PROGRAM -> 2;
            default -> 0;
        };
    }
}

