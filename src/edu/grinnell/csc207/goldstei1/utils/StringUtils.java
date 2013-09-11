package edu.grinnell.csc207.goldstei1.utils;

public class StringUtils {

    /**
     * Method to split a string at every instance of a certain
     *  character "splitter"
     * 
     */
    public static String[] splitAt(String str, char splitter) {
	//create new string
	//loop through to count how many times a splitter appears in str
	int count = 0;
	for (int i = 0; i < str.length(); i++) {
	    if(str.charAt(i) == splitter) {
		count++;
	    }//if
	}//for
	
	//The number of strings after splitting will be count + 1
	String[] splitStrings = new String[count + 1];
	
	//loop through strings
	//fill temporary StringBuffer with characters until we reach splitter
	//transfer stringBuffer to array
	int arrayPosition = 0;
	StringBuffer part = new StringBuffer();
	for (int i = 0; i < str.length(); i++) {
	    if(str.charAt(i) == splitter) {
		splitStrings[arrayPosition] = part.toString();
		arrayPosition++;
		part.delete(0, part.length());
	    }//if
	    else {
		part.append(str.charAt(i));
	    }//else
	}//for
	splitStrings[arrayPosition] = part.toString();
	return splitStrings;
    }//splitAt
}//StringUtils

