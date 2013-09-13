package edu.grinnell.csc207.goldstei1.utils;

import java.math.BigInteger;

public class Calculator {
    
    
    public static BigInteger eval0(String expression) {
	
	StringBuffer evaluator = new StringBuffer(expression);
	int i = 0;
	char nextOperation = ' ';
	int begOfNum;
	BigInteger endValue = new BigInteger("0");
	
	
	while(i < evaluator.length() && evaluator.charAt(i) != ' ') {
	    i++;
	}
	endValue = endValue.add(new BigInteger(evaluator.substring(0, i).toString()));
	i++;
	
	while (i < evaluator.length()) {
	    switch (evaluator.charAt(i)) {
	    case '+': nextOperation = '+';
	    break;
	    case '-': nextOperation = '-';
	    break;
	    case '*': nextOperation = '*';
	    break;
	    case '/': nextOperation = '/';
	    break;
	    case '^': nextOperation = '^';
	    }
	    i += 2;
	    
	    begOfNum = i;
	    
	    while(i < evaluator.length() && i != ' ') {
		i++;
	    }
	    
	    switch (nextOperation) {
	    case '+': endValue = endValue.add(new BigInteger(evaluator.substring(begOfNum, i).toString()));
	    break;
	    case '-': endValue = endValue.subtract(new BigInteger(evaluator.substring(begOfNum, i).toString()));
	    break;
	    case '*': endValue = endValue.multiply(new BigInteger(evaluator.substring(begOfNum, i).toString()));
	    break;
	    case '/': endValue = endValue.divide(new BigInteger(evaluator.substring(begOfNum, i).toString()));
	    break;
	    case '^': endValue = endValue.pow(new Integer(evaluator.substring(begOfNum, i).toString()));
	    break;
	    }
	    i +=2;
	}
	
	return endValue;
	
    }

}
