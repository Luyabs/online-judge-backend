package com.example.onlinejudge.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目修难度
 */
public enum ProblemDifficulty implements EnumIndex {
    NULL("null"),
    EASY("简单"),
    MEDIUM("中等"),
    HARD("困难");

    public final String difficulty;
    public final List<Integer> difficultyList = Arrays.asList(1,2,3);
    ProblemDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public static ProblemDifficulty get(int index) {
        return switch (index) {
            case 1 -> EASY;
            case 2 -> MEDIUM;
            case 3 -> HARD;
            default -> NULL;
        };
    }

    @Override
    public int index() {
        return switch (this) {
            case EASY -> 1;
            case MEDIUM -> 2;
            case HARD -> 3;
            default -> 0;
        };
    }
}
