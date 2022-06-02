package hu.progmatic.services;

import hu.progmatic.model.Element;
import hu.progmatic.model.Rarity;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    private final static String TEST_BASE_DRAGON_PATH = "src/test/resources/test_dragons.txt";
    private final static String TEST_USER_DRAGON_PATH = "src/test/resources/test_user_dragons.txt";

    @Test
    void testLoadBaseDragons() {
        DataHandler dataHandler = new DataHandler();
        try {
            dataHandler.loadBaseDragons(TEST_BASE_DRAGON_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        assertEquals(20,dataHandler.getBaseDragonList().size());
    }

    @Test
    void testLoadUserDragons(){
        DataHandler dataHandler = new DataHandler();
        try {
            dataHandler.loadBaseDragons(TEST_BASE_DRAGON_PATH);
            dataHandler.loadUserDragons(TEST_USER_DRAGON_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        assertEquals(9,dataHandler.getUserDragonList().size());
    }

    @Test
    void testLoadFiles() {
        DataHandler dataHandler = new DataHandler();
        assertTrue(dataHandler.loadFiles(TEST_BASE_DRAGON_PATH, TEST_USER_DRAGON_PATH));
        assertFalse(dataHandler.loadFiles("eznincs.txt","ezsincs.txt"));
        assertFalse(dataHandler.loadFiles("eznincs.txt", TEST_USER_DRAGON_PATH));
        assertFalse(dataHandler.loadFiles(TEST_BASE_DRAGON_PATH, "eznincs.txt"));
    }

    @Test
    void testCountNamelessUserDragons(){
        DataHandler dataHandler = new DataHandler();
        dataHandler.loadFiles(TEST_BASE_DRAGON_PATH, TEST_USER_DRAGON_PATH);
        assertEquals(2,dataHandler.countNamelessUserDragons());
    }

    @Test
    void testGetBaseDragonsWithoutUserDragon(){
        DataHandler dataHandler = new DataHandler();
        dataHandler.loadFiles(TEST_BASE_DRAGON_PATH, TEST_USER_DRAGON_PATH);
        assertEquals(11,dataHandler.getBaseDragonsWithoutUserDragon().size());
    }

    @Test
    void testGetDragonsWithElement(){
        DataHandler dataHandler = new DataHandler();
        dataHandler.loadFiles(TEST_BASE_DRAGON_PATH, TEST_USER_DRAGON_PATH);
        assertEquals(9,dataHandler.getDragonsWithElement(Element.getByValue(1)).size());
    }

    @Test
    void testGetUserDragonsWithFirstElement(){
        DataHandler dataHandler = new DataHandler();
        dataHandler.loadFiles(TEST_BASE_DRAGON_PATH, TEST_USER_DRAGON_PATH);
        assertEquals(2,dataHandler.getUserDragonsWithFirstElement(Element.getByValue(2)).size());
    }

    @Test
    void testGetBaseDragonsGroupByRarity(){
        DataHandler dataHandler = new DataHandler();
        dataHandler.loadFiles(TEST_BASE_DRAGON_PATH, TEST_USER_DRAGON_PATH);
        assertEquals(1,dataHandler.getBaseDragonsGroupByRarity().get(Rarity.RARE).size());
    }

    @Test
    void testGetBaseDragonsCountByRarity(){
        DataHandler dataHandler = new DataHandler();
        dataHandler.loadFiles(TEST_BASE_DRAGON_PATH, TEST_USER_DRAGON_PATH);
        assertEquals(19, dataHandler.getBaseDragonsCountByRarity().get(Rarity.COMMON));
    }

    @Test
    void countMaxLevelUserDragons() {
        DataHandler dataHandler = new DataHandler();
        dataHandler.loadFiles(TEST_BASE_DRAGON_PATH, TEST_USER_DRAGON_PATH);
        assertEquals(2,dataHandler.countMaxLevelUserDragons());
    }
}