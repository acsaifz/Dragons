package hu.progmatic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDragonTest {

    @Test
    void testUserDragon() {
        UserDragon userDragon = new UserDragon(new BaseDragon(1,"TestDragon",4,"its a test dragon",new String[]{"5","13"}),"Test",10,5);
        assertEquals(1,userDragon.getBaseDragon().getId());
        assertEquals("TestDragon",userDragon.getBaseDragon().getName());
        assertEquals(Rarity.EPIC,userDragon.getBaseDragon().getRarity());
        assertEquals("its a test dragon", userDragon.getBaseDragon().getDescription());
        assertArrayEquals(new Element[]{Element.ELECTRIC,Element.PRIMAL},userDragon.getBaseDragon().getElements());
        assertEquals("Test", userDragon.getName());
        assertEquals(10, userDragon.getLevel());
        assertEquals(5,userDragon.getStar());
    }

    @Test
    void testGetMaxLevel() {
        assertEquals(40, UserDragon.getMaxLevel(0));
        assertEquals(45, UserDragon.getMaxLevel(1));
        assertEquals(60, UserDragon.getMaxLevel(4));
        assertEquals(70, UserDragon.getMaxLevel(5));
        assertThrows(IllegalStateException.class,() -> UserDragon.getMaxLevel(-1));
        assertThrows(IllegalStateException.class,() -> UserDragon.getMaxLevel(6));
        assertDoesNotThrow(()->UserDragon.getMaxLevel(1));
    }
}