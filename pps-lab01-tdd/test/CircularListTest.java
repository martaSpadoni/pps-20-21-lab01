import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final static int NUMBER_OF_ADD = 10;

    private CircularList circularList;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
    }

    @Test
    void testInitiallyEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testAdd(){
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testInitialSize(){
        assertEquals(0, circularList.size());
    }

    @Test
    void testSizeAfterAdd(){
        circularList.add(1);
        assertEquals(1, circularList.size());
    }

    @Test
    void testMultipleAdd(){
        for(int i = 0; i < NUMBER_OF_ADD; i++){
            circularList.add(i);
        }
        assertEquals(10, circularList.size());

    }

}
