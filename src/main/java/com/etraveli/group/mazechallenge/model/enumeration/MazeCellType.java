package com.etraveli.group.mazechallenge.model.enumeration;

import java.util.Arrays;

public enum MazeCellType {
    ROAD("-", 0),
    WALL("X", 1),
    START("S", 2),
    EXIT("G", 3);

    private String text;
    private int code;

    MazeCellType(String text, int code) {
        this.text = text;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public int getCode() {
        return code;
    }

    public static MazeCellType fromText(String text) {
        return Arrays.stream(MazeCellType.values())
                .filter(type -> text.equals(type.getText()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong type"));
    }
}
