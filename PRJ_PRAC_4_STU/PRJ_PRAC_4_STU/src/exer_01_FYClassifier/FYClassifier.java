package exer_01_FYClassifier;

import jconsole.JConsole;
import java.awt.Color;

public class FYClassifier {

	// Do not modify main in any way, except where stated
	// Penalty: -100%
	public static void main(String[] args)
	{
		double ueeMark;
		int books, series;
		JConsole console = new JConsole(100, 30);

		console.println("--------------------------");
		console.println("THE FIRST-YEARS CLASSIFIER");
		console.println("--------------------------");
		console.println();

		ueeMark = readUEEMark(console);    
		books = readNumberOf("BOOKS read", console); 
		series = readNumberOf("SERIES watched", console); 

		        showResults (ueeMark, books, series, console);
        /* COMPLETE 
        	invoke procedure showResults providing the required parameters
        */
        

        console.setCursorPosition(0, console.getRows()-1);
        console.print("Press any key to exit");
        console.readKey();
        
        System.exit(0);
    }

	 private static double readUEEMark (JConsole console)
	    {
	        double result;

	        console.print("Please enter UEE mark (in [5, 10]) ");
	        console.setForegroundColor(Color.GREEN);
	        
	        do {
	         result = console.readDouble();	
	        }while (result<= 5 && result >= 10);
	        
	        console.resetColor ();
	        return result;
	    }

	    private static int readNumberOf (String what,  JConsole console) {
	        int result;
	        console.print("Please enter number of "+what+": ");
	        console.setForegroundColor(Color.GREEN);
	        result = console.readInt();
	        while (result<0) {
	        	console.println("That number must be positive");
	        	result = console.readInt();
	        }
	        return result;
	    }

	    private static char classifyUEEMark (double ueeMark){
	        
	    	char ueeType;
	        
	        if (ueeMark<=6.5){
	        	ueeType = 'L';
	        }
	        	else if (ueeMark>6.5 && ueeMark<8) {
	        		ueeType = 'N';
	        	}
	        		else if (ueeMark>=8 && ueeMark<=9.5){
	        			ueeType = 'H';
	        		}
	        			else  {
	        				ueeType = 'V';
	        			}
	        return ueeType;
	    }

	    /* COMPLETE: write here procedure ClassifyDoubleDIndex.
	       Parameter, only one, is int (the doubleD index).
	       Return type is string
	    */

	    private static String classifyDoubleDIndex (int doubleD, JConsole console) {
	    
	    	String index;
	    	
	    	if (doubleD< 0) {
	    		index = "NEGATIVE";
	    		return index;
	    	}
		    else if (doubleD>=0 && doubleD<=4) {
		    	index = "SLIGHTLY POSITIVE";
		    	return index;
		    }
		    else {
		    	index = "POSITIVE";
			    return index;
		    }  	
	    }

	 private static char determineCategory (String indexType, char ueeType){
    	char category;
    	
    	if (indexType == "NEGATIVE" ) {
    	
    		if (ueeType == 'L' || ueeType =='N') {
    		category = 'A';
    		return category;
    		
    		}
    		else {
    		category = 'B';
    		return category;
    		}
    		 
    	}
    	
    	else if (indexType == "SLIGHTLY POSITIVE") {
    		if (ueeType == 'L' ){
    			category = 'C';
    			return category;
    		}
    		else if (ueeType == 'V') {
    			category = 'F';
    			return category;
    		}
    		else {
    			category = 'E';
    			return category;
    		}
    	}
    	
    	else {
    		if (ueeType == 'L' ){
    			category = 'D';
    			return category;
    		}
    		else if (ueeType == 'V') {
    			category = 'F';
    			return category;
    		}
    		else {
    			 category = 'E';
    			return category;
    		}
    	}
    	
    }

    private static String getAdviceFromCategory  (char category)
    {
    	String advice;
    	
    	if (category == 'A'){
    		advice = "Beware: you are a high-risk student. Train your concentration and change habits.";
    		return advice;
    	}
    	
    	else if(category == 'B'){
    		advice = "Be careful and turn the screen off. First year can be more demanding than you expect.";
    		return advice;
    		
    	}
    	
    	else if(category == 'C'){
    		advice = "Beware: you are a mid-risk student. Get rid of all distractors and work really hard.";
    		return advice;
    	}
    	
    	else if(category == 'D'){
    		advice = "You may have the potential for success but you will have to work hard in a daily-basis";
    		return advice;
    	}
    	
    	else if(category == 'E'){
    		advice = "Get ready for a demanding term. Carefully plan your time.";
    		return advice;
    	}
    	
    	else {
    		advice = "Good habits pay off. Keep on concentrating on what matters.";
    		return advice;
    	}
    }

    private static void showResults (double ueeMark, int books, int series, JConsole console)
    {
        int doubleDIndex;
        char ueeType, category;
        String indexType, advice;

        doubleDIndex = books - series;

        ueeType = classifyUEEMark(ueeMark);  
        ueeType = classifyUEEMark (ueeMark);
        indexType =classifyDoubleDIndex (doubleDIndex, console);
        category = determineCategory (indexType, ueeType);
        advice = getAdviceFromCategory (category);

		/* COMPLETE 
           initialize variables category and advice with the values returned by 
           functions DetermineCategory and GetAdviceFromCategory. Provide required
           parameters
		 */

		console.println(); console.println();

		console.print("Your UEE mark of "+ueeMark+" points is considered ");
		console.setForegroundColor(Color.MAGENTA);
		console.println(ueeType);
		console.resetColor();

		console.println("With "+books+" books and "+series+" series you have a Doble D index of "+doubleDIndex);
		console.print("This index is considered: ");
		console.setForegroundColor(Color.MAGENTA);
		console.println(indexType);
		console.resetColor();

		console.print("Then, your category is ");
		console.setForegroundColor(Color.MAGENTA);
		console.println(category);
		console.resetColor();

		console.println("and you should consider following this advice:");
		console.setForegroundColor(Color.RED);
		console.println("\t" + advice);
		console.resetColor();
	}
}
