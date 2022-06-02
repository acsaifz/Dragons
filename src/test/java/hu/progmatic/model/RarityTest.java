package hu.progmatic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RarityTest {

    @Test
    void getByValue() {
        assertEquals(Rarity.UNDEFINED, Rarity.getByValue(0));
        assertEquals(Rarity.COMMON, Rarity.getByValue(1));
        assertEquals(Rarity.HEROIC, Rarity.getByValue(6));
        assertEquals(Rarity.UNDEFINED, Rarity.getByValue(-1));
        assertEquals(Rarity.UNDEFINED, Rarity.getByValue(7));
    }
}