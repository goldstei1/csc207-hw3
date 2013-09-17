package edu.grinnell.csc207.goldstei1.utils;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertArrayEquals;


import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void eval0Test() {
	assertEquals(new BigInteger("0"), Calculator.eval0("0"));
	assertEquals(new BigInteger("2"), Calculator.eval0("1 + 1"));
	assertEquals(new BigInteger("4"), Calculator.eval0("1 + 2 + 1"));
	assertEquals(new BigInteger("9"), Calculator.eval0("1 + 2 * 3"));
	assertEquals(new BigInteger("298576849383746829123456796"),
					 Calculator.eval0("2985768493837468291234567890 / 10 + 7"));
	assertEquals(new BigInteger("16"), Calculator.eval0("1 + 2 / 3 + 7 - 6 ^ 4"));
    }
    
    @Test
    public void fewestCoinsTest() {
    	assertArrayEquals(new int[] {0, 0, 5, 0}, Calculator.fewestCoins(55));
    	assertArrayEquals(new int[] {0, 0, 0, 0}, Calculator.fewestCoins(0));
    	assertArrayEquals(new int[] {0, 2, 1, 0}, Calculator.fewestCoins(25));
    	assertArrayEquals(new int[] {0, 4, 0, 0}, Calculator.fewestCoins(28));
    	assertArrayEquals(new int[] {0,0,0,2}, Calculator.fewestCoins(108));
    	assertArrayEquals(new int[] {1,1,1,0}, Calculator.fewestCoins(20));
        }


}
