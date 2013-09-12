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
    
    /**
     * Method to split a string at every instance of a character "splitter"
     * except when this character is meant to be part of the string.
     */
  public static String[] splitCSV(String str, char splitter) {
	  int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '\"') { 
				i++;
				while(str.charAt(i) != '\"') {
					i++;
				}
			}	
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
		int inQuote = 0;
		StringBuffer part = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '\"') { //enter into a quotation, disregarding splitters
				if(str.charAt(i + 1) == '\"') {
					i++;
					part.append(str.charAt(i));
				}//if
				else if(inQuote == 1) {
					inQuote = 0;
				}//else if
				else { 
					inQuote = 1; //when not in quote mode, go into quote mode		
				}//else	
			}//if
			else if(str.charAt(i) == splitter && inQuote == 0) {
				splitStrings[arrayPosition] = part.toString();
				arrayPosition++;
				part.delete(0, part.length());
			}//else if
			else {
				part.append(str.charAt(i));
			}//else
		}//for
		splitStrings[arrayPosition] = part.toString();
		return splitStrings;
  }//splitCSV
  
  public static String deLeet(String leet) {
	  StringBuffer editor = new StringBuffer(leet);
	  int i;
	  for(i = 0; i < editor.length(); i++) {
		  switch (editor.charAt(i)) {
		  	case '+': editor.setCharAt(i, 't');
		  			  break;
		  	case '3': editor.setCharAt(i, 'e');
			  		  break;
		  	case '1': editor.setCharAt(i, 'l');
		  			  break;
		  	case '0': editor.setCharAt(i, 'o');
		  			  break;
		  	case '@': editor.setCharAt(i, 'a');
		  			  break;
		  	case '$': editor.setCharAt(i, 's');
		  			  break;
		  	case '|': if(i + 2 < editor.length()) {
		  			  	  if(editor.substring(i, i+3).toString().equals("|\\|")) {
		  			  		  editor.replace(i, i+3, "n");
		  			  		  break;
		  			  	  }//if
		  	          }//if
		  			  if(i + 1 < editor.length()) {
		  				  if(editor.substring(i, i+2).toString().equals("|3")) {
		  					  editor.replace(i,  i+2, "b");
		  					  break;
		  				  }//if
		  			  }//if
		  			  else {
		  				  break;
		  			  }//else
		  	default: break;		 
		  			  
		  	}//switch
		  }//for
	  return editor.toString();
	  }//deLeet
  
  public static void main(String[] args) {
	  String stuff = "abcdefg";
	  StringBuffer blah = new StringBuffer(stuff);
	  blah.replace(2, 4, "hi");
	  System.out.println(blah.toString());
	  
	  
  }
}//StringUtils

