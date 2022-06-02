package hu.progmatic.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    @Test
    void getByValue() {
        assertEquals(Element.UNDEFINED, Element.getByValue(0));
        assertEquals(Element.TERRA, Element.getByValue(1));
        assertEquals(Element.DREAM, Element.getByValue(21));
        assertEquals(Element.UNDEFINED, Element.getByValue(-1));
        assertEquals(Element.UNDEFINED, Element.getByValue(22));
    }

    @Test
    void getAllByValues() {
        String[] elementValues = {"1", "3", "2"};
        String[] expected = {"TERRA", "SEA", "FLAME"};
        Element[] elements = Element.getAllByValues(elementValues);
        assertEquals(Arrays.toString(expected), Arrays.toString(elements));
    }
}