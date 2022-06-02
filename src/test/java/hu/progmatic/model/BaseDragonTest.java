package hu.progmatic.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseDragonTest {
    BaseDragon baseDragon = new BaseDragon(
            1,
            "Terra",
            1,
            "It's a description",
            new String[]{"1", "2"}
    );

    @Test
    void toStringTest(){
        assertEquals("BaseDragon{id=1, name='Terra', rarity=COMMON, description='It's a description', elements=[TERRA, FLAME]}",baseDragon.toString());
    }
}