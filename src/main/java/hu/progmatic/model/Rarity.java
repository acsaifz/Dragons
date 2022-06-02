package hu.progmatic.model;

public enum Rarity {
    UNDEFINED,
    COMMON,
    RARE,
    VERY_RARE,
    EPIC,
    LEGEND,
    HEROIC;


    public static Rarity getByValue(int value){
        return switch (value){
            case 1 -> COMMON;
            case 2 -> RARE;
            case 3 -> VERY_RARE;
            case 4 -> EPIC;
            case 5 -> LEGEND;
            case 6 -> HEROIC;
            default -> UNDEFINED;
        };
    }
}
