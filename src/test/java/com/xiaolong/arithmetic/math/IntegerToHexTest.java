package com.xiaolong.arithmetic.math;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class IntegerToHexTest {

    IntegerToHex curr ;

    @Test
    public void testBitOpr(){
        int a = -2;
        int b = 2;

        System.out.println(a >> 1);
        System.out.println(a >>> 1);
        System.out.println(b >> 1);
        System.out.println(b >>> 1);
    }

    @Test
    public void testIntegerToHex(){
        curr = new IntegerToHex();
        curr.toHex(-1);
    }

}