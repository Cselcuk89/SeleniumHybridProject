package com.selcuk.enums;

public enum Colors {
    BLACK("Black"),
    ORANGE("Orange"),
    YELLOW("Yellow");
    private final String color;
    Colors(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
}
;