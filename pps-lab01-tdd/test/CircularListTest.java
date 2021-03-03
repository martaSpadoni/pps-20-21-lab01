import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final static int NUMBER_OF_ELEMENT = 10;
    private final static int NUMBER_OF_NEXT = 5;

    private CircularList circularList;
    private final SelectStrategyFactory factory = new SelectStrategyFactoryImpl();

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

    private void fillCircularList(){
        IntStream.range(0, NUMBER_OF_ELEMENT)
                .forEach(i -> circularList.add(i));
    }

    @Test
    void testMultipleAdd(){
        fillCircularList();
        assertEquals(NUMBER_OF_ELEMENT, circularList.size());
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
        fillCircularList();
        IntStream.rangeClosed(0, NUMBER_OF_NEXT)
                .forEach(i -> circularList.next());
        assertEquals(Optional.of(NUMBER_OF_NEXT+1), circularList.next());
    }

    @Test
    void testNextUntilEnd(){
        fillCircularList();
        IntStream.range(0, circularList.size()).
                forEach(i -> circularList.next());
        assertEquals(Optional.of(0), circularList.next());
    }

    @Test
    void testNextOnEmptyList(){
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test
    void testFirstPrevious(){
        fillCircularList();
        assertEquals(Optional.of(NUMBER_OF_ELEMENT-1), circularList.previous());
    }

    @Test
    void testPreviousOnEmptyList(){
        assertEquals(Optional.empty(), circularList.previous());
    }

    @Test
    void  testPreviousUntilFirstElement(){
        fillCircularList();
        IntStream.range(0, circularList.size()-1)
                .forEach(i -> circularList.previous());
        assertEquals(Optional.of(0), circularList.previous());
    }

    @Test
    void testNextAndPrevious(){
        fillCircularList();
        circularList.next();
        assertEquals(Optional.of(1), circularList.next());
        assertEquals(Optional.of(1), circularList.previous());
        assertEquals(Optional.of(0), circularList.previous());
        assertEquals(Optional.of(9), circularList.previous());
    }

    @Test
    void testResetAfterNext(){
        fillCircularList();
        circularList.next();
        circularList.reset();
        assertEquals(Optional.of(0), circularList.next());
    }

    @Test
    void testResetAfterPrevious(){
        fillCircularList();
        circularList.previous();
        circularList.reset();
        assertEquals(Optional.of(9), circularList.previous());
    }

    @Test
    void  testReset(){
        fillCircularList();
        circularList.previous();
        circularList.previous();
        circularList.next();
        circularList.reset();
        circularList.next();
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    void testNextWithEvenStrategy(){
        fillCircularList();
        assertEquals(Optional.of(0), circularList.next(factory.createEvenStrategy()));
        assertEquals(Optional.of(2), circularList.next(factory.createEvenStrategy()));
        assertEquals(Optional.of(4), circularList.next(factory.createEvenStrategy()));
    }

    @Test
    void testNextWithMultipleOfStrategy(){
        fillCircularList();
        assertEquals(Optional.of(0), circularList.next(factory.createMultipleOfStrategy(5)));
        assertEquals(Optional.of(5), circularList.next(factory.createMultipleOfStrategy(5)));
        assertEquals(Optional.of(0), circularList.next(factory.createMultipleOfStrategy(5)));
    }

    @Test
    void testNextWithEqualsStrategy(){
        fillCircularList();
        assertEquals(Optional.of(3), circularList.next(factory.createEqualsStrategy(3)));
        assertEquals(Optional.of(3), circularList.next(factory.createEqualsStrategy(3)));
    }

    @Test
    void testNextWithDifferentStrategy(){
        fillCircularList();
        assertEquals(Optional.of(6), circularList.next(factory.createEqualsStrategy(6)));
        assertEquals(Optional.of(8), circularList.next(factory.createEvenStrategy()));
        assertEquals(Optional.of(9), circularList.next(factory.createMultipleOfStrategy(3)));
        assertEquals(Optional.empty(), circularList.next(factory.createEqualsStrategy(20)));
        assertEquals(Optional.of(0), circularList.next(factory.createEvenStrategy()));
    }

    @Test
    void  testNextWithStrategyOnEmptyList(){
        assertEquals(Optional.empty(), circularList.next(factory.createEqualsStrategy(12)));
    }






}
