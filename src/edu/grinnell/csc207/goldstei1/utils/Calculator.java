package edu.grinnell.csc207.goldstei1.utils;

import java.math.BigInteger;

public class Calculator {
    
    
	/**
	 * Method to solve a mathematical expression given as a string
	 *  with spaces between each number and operation. The numbers
	 *  in the string can be larger than a normal integer.
	 */
	public static BigInteger eval0(String expression) {

		StringBuffer evaluator = new StringBuffer(expression);
		BigInteger endValue = new BigInteger("0"); //first number in string is added later
		char nextOperation = '+'; // first operation is always add
		int begOfNum;
		int i = 0; //starting index of the evaluator string


		while (i < evaluator.length()) {
			//Check for which operation will happen next
			// first time through will skip this section
			switch (evaluator.charAt(i)) {
			case '+': nextOperation = '+';
			i += 2;
			break;
			case '-': nextOperation = '-';
			i += 2;
			break;
			case '*': nextOperation = '*';
			i += 2;
			break;
			case '/': nextOperation = '/';
			i += 2;
			break;
			case '^': nextOperation = '^';
			i += 2;
			break;
			}//switch

			//index of the beginning of the next number
			begOfNum = i;

			while(i < evaluator.length() && evaluator.charAt(i) != ' ') {
				i++;
			}//while

			//end of next number is now i so do the operation
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
			}//switch

			i++;
		}//While

		return endValue;
	}
}
