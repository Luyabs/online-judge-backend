package com.example.onlinejudge.common.constant;

/**
 * 题目修难度
 */
public enum ProblemDifficulty {
    NULL("null"),
    EASY("简单"),
    MEDIUM("中等"),
    HARD("困难");

    public final String difficulty;

    ProblemDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getRoleName() {
        return difficulty;
    }

    public static ProblemDifficulty getProblemDifficulty(int index) {
        return switch (index) {
            case 1 -> ProblemDifficulty.EASY;
            case 2 -> ProblemDifficulty.MEDIUM;
            case 3 -> ProblemDifficulty.HARD;
            default -> ProblemDifficulty.NULL;
        };
    }

    public static int getIndex(ProblemDifficulty type) {
        return switch (type) {
            case EASY -> 1;
            case MEDIUM -> 2;
            case HARD -> 3;
            default -> 0;
        };
    }
}
