package hu.progmatic.model;

import java.util.concurrent.ExecutionException;

public enum Element {
    UNDEFINED,
    TERRA,
    FLAME,
    SEA,
    NATURE,
    ELECTRIC,
    ICE,
    METAL,
    DARK,
    LIGHT,
    WAR,
    PURE,
    LEGEND,
    PRIMAL,
    WIND,
    TIME,
    HAPPY,
    CHAOS,
    MAGIC,
    SOUL,
    BEAUTY,
    DREAM;

    public static Element getByValue(int value){
        return switch (value){
            case 1 -> TERRA;
            case 2 -> FLAME;
            case 3 -> SEA;
            case 4 -> NATURE;
            case 5 -> ELECTRIC;
            case 6 -> ICE;
            case 7 -> METAL;
            case 8 -> DARK;
            case 9 -> LIGHT;
            case 10 -> WAR;
            case 11 -> PURE;
            case 12 -> LEGEND;
            case 13 -> PRIMAL;
            case 14 -> WIND;
            case 15 -> TIME;
            case 16 -> HAPPY;
            case 17 -> CHAOS;
            case 18 -> MAGIC;
            case 19 -> SOUL;
            case 20 -> BEAUTY;
            case 21 -> DREAM;
            default -> UNDEFINED;
        };
    }

    public static Element[] getAllByValues(String[] values){
        Element[] elements = new Element[values.length];
        for (int i = 0; i < values.length; i++){
            elements[i] = getByValue(Integer.parseInt(values[i]));
        }
        return elements;
    }
}
