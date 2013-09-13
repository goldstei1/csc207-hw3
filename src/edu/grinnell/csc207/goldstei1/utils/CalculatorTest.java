package edu.grinnell.csc207.goldstei1.utils;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void eval0() {
	assertEquals(new BigInteger("0"), Calculator.eval0("0"));
	assertEquals(new BigInteger("2"), Calculator.eval0("1 + 1"));
	assertEquals(new BigInteger("4"), Calculator.eval0("1 + 2 + 1"));
	assertEquals(new BigInteger("9"), Calculator.eval0("1 + 2 * 3"));
    }

}
