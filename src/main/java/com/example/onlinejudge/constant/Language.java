package com.example.onlinejudge.constant;

/**
 * 答题所用语言
 */
public enum Language implements EnumIndex {
    NULL("null"),
    MYSQL("MySQL"),
    JAVA("Java");

    public final String language;

    Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public static Language get(int index) {
        return switch (index) {
            case 1 -> MYSQL;
            case 2 -> JAVA;
            default -> NULL;
        };
    }

    @Override
    public int index() {
        return switch (this) {
            case MYSQL -> 1;
            case JAVA -> 2;
            default -> 0;
        };
    }
}
