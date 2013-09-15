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
	}//eval0
	
	
	public static int[] fewestCoins(int amount) {
		
		int wot = 2;
		int eater = 7;
		int stickpair = 11;
		int deck = 54;
		int testNum = 0;
		int currentMin = -1;
		int maxWot = amount/wot;
		int maxEater = amount/eater;
		int maxStickpair = amount/stickpair;
		int maxDeck = amount/deck;
		int[] coinCount = new int[4];
		
		//loop through all the permutations and if their sum = amount
		// then check if 
		for(int i = 0; i <= maxWot; i++) {
			testNum += wot*i;
			for(int j = 0; j <= maxEater; j++) {
				testNum += eater*j;
				for(int k = 0; k <= maxStickpair; k++) {
					testNum += stickpair*k;
					for(int p = 0; p <= maxDeck; p++) {
						testNum += deck*p;
						if(testNum == amount) {
							if(i + j + k + p < currentMin || currentMin == -1) {
								coinCount[0] = wot*i;
								coinCount[1] = eater*j;
								coinCount[2] = stickpair*k;
								coinCount[3] = deck*p;
								currentMin = i + j + k + p;
							}//if(i+j+k+p....)
						}//if(test=amount)
						testNum -= deck*p;		
					}//for(p)
					testNum -= stickpair*k;
				}//for(k)
				testNum -= eater*j;
			}//for(j)
			testNum -= wot*i;
		}//for(i)
		return coinCount;	
	}
}
