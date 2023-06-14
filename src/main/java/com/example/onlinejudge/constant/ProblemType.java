package com.example.onlinejudge.constant;

/**
 * 题目类型
 */
public enum ProblemType implements EnumIndex {
    NULL("null"),
    SQL("SQL题"),
    PROGRAM("高级语言程序");

    public final String typeName;

    ProblemType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public static ProblemType get(int index) {
        return switch (index) {
            case 1 -> SQL;
            case 2 -> PROGRAM;
            default -> NULL;
        };
    }

    @Override
    public int index() {
        return switch (this) {
            case SQL -> 1;
            case PROGRAM -> 2;
            default -> 0;
        };
    }
}

