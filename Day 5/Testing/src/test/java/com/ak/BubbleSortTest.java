package com.ak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void testShift2Char() throws Exception {
        StringAlgo obj  = new StringAlgo();
        String input = "Hello";
        String expected = "lloHe";
        String actual = obj.funct(input);

        assertEquals(expected,actual);

    }

    @Test
    void testSmallInput(){
        StringAlgo obj = new StringAlgo();
        String input = "a";
        assertThrows(StringIndexOutOfBoundsException.class,()->{
            String actual = obj.funct(input);
        });
    }

}