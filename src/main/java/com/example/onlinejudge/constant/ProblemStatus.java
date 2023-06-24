package com.example.onlinejudge.constant;

public enum ProblemStatus implements EnumIndex{
    NULL("null"),
    WAIT("待审核"),        //0
    VERIFIED("审核通过"),   //1

    VERIFYING("审核中"),    //2
    FAILED("审核失败"),     //3

    HISTORY("历史");      //4

    public final String status;
    ProblemStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public static ProblemStatus get(int index) {
        return switch (index) {
            case 0 -> WAIT;
            case 1 -> VERIFIED;
            case 2 -> VERIFYING;
            case 3 -> FAILED;
            case 4 -> HISTORY;
            default -> ProblemStatus.NULL;
        };
    }
    @Override
    public int index() {
        return switch (this){
            case  WAIT  -> 0;
            case  VERIFIED  -> 1;
            case  VERIFYING -> 2;
            case  FAILED    -> 3;
            case  HISTORY   -> 4;
            default -> -1;
        };
    }
}
