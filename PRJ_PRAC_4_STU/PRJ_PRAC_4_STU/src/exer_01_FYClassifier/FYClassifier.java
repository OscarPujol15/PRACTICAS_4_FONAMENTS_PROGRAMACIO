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
        
        /* COMPLETE */
        
        console.resetColor ();
        return result;
    }

    private static int readNumberOf (String what,  JConsole console)
    {
        int result;
        console.print("Please enter number of "+what+": ");
        console.setForegroundColor(Color.GREEN);
        result = console.readInt();
    
        /* COMPLETE */
    }

    private static char classifyUEEMark (double ueeMark)
    {
        char ueeType;

        /* COMPLETE */
    }

    /* COMPLETE: write here procedure ClassifyDoubleDIndex.
       Parameter, only one, is int (the doubleD index).
       Return type is string
    */

    private static char determineCategory (String indexType, char ueeType)
    {
    	/* COMPLETE */
    }

    private static String getAdviceFromCategory  (char category)
    {
    	/* COMPLETE */
    }

    private static void showResults(double ueeMark, int books, int series, JConsole console)
    {
        int doubleDIndex;
        char ueeType, category;
        String indexType, advice;

        doubleDIndex = books - series;

        ueeType = classifyUEEMark(ueeMark); 
        indexType = classifyDoubleDIndex(doubleDIndex); 
        
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
