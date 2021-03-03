import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final static int NUMBER_OF_ADD = 10;
    private final static int NUMBER_OF_NEXT = 5;

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

    @Test
    void testNextOneElement() {
        circularList.add(1);
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    void testTwiceNext(){
        circularList.add(1);
        circularList.add(2);
        circularList.next();
        assertEquals(Optional.of(2), circularList.next());
    }

    @Test
    void testNext(){
        circularList.add(1);
        circularList.next();
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    void testMultipleNext(){
        for(int i = 0; i < NUMBER_OF_ADD; i++){
            circularList.add(i);
        }

        for(int i = 0; i <= NUMBER_OF_NEXT; i++){
            circularList.next();
        }

        assertEquals(Optional.of(6), circularList.next());

    }

    @Test
    void testNextUntilEnd(){
        for(int i = 0; i < NUMBER_OF_ADD; i++){
            circularList.add(i);
        }

        for(int i = 0; i <= circularList.size(); i++){
            circularList.next();
        }

        assertEquals(Optional.of(1), circularList.next());

    }

}
