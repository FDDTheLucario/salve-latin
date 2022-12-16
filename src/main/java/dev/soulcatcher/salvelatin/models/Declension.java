package dev.soulcatcher.salvelatin.models;

public enum Declension {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5);

    private int code;

    Declension(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
