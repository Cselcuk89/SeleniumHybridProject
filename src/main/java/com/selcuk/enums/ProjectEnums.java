package com.selcuk.enums;

public enum ProjectEnums {
    TSHIRTS("T-shirts"),
    BLOUSES("Blouses"),
    CASUALDRESSES("Casual Dresses");
    private final String outfit;

    ProjectEnums(String outfit) {
        this.outfit = outfit;
    }

    public String getOutfit(){
        return outfit;
    }
}
