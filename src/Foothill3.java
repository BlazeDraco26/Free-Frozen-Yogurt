// Lab #4
// Jordan Cheng

import java.util.Scanner;

public class Foothill3
{
   // define constants
   private static final char SHUT_DOWN = 'S';
   private static final char CALCULATE = 'C';
   private static final char NO = 'N';
   private static final char YES = 'Y';
   private static final char FACTORIAL = 'F';
   private static final char GAUSSIAN = 'G';
   
   private static final String INDENT = "   ";  
   private static final String SEPARATOR = "\n"; 
   
   private static final String OPTIONS = "Options:";
   private static final String SHUT_DOWN_CHOICE = INDENT + SHUT_DOWN 
                                                               + " (Shut Down)";
   private static final String PURCHASE_CHOICE = INDENT + CALCULATE
                                                       + " (Calculate)";
   private static final String USER_CHOICE = SEPARATOR + "Your choice:";  
   private static final String BAD_LETTER_MSG = " *** Use " + CALCULATE + " or "
                                       + SHUT_DOWN + " please *** " + SEPARATOR;
   private static final String BAD_LETTER_MSG2 = " *** Use " + FACTORIAL + " or "
         + GAUSSIAN + " please *** " + SEPARATOR;
   private static final String MATHEMATICAL_PROMPT = 
                                    "Factorial or Gaussian Sum? ";
   private static final String INVALID_RESPONSE = " *** Invalid response *** "
                                                                  + SEPARATOR;
   private static final String INVALID_INPUT = 
                                          " *** Invalid input *** "
                                                                   + SEPARATOR;
   private static final String QUALIFIED_FOR_FREE_YOGURT = 
                                 "You qualify for a free yogurt. " 
                                       + "Would you like to use your "
                                          + "credits? (Y or N)";
   private static final String INTEGER_PROMPT = " Please enter an integer between 1 - 200 to calculate. ";
   private static final String SHUT_DOWN_MSG = "Shutting down... Bye!";
   
   private static final boolean KEEP_LOOPING = true;
   
   private static final int FREE_FROZEN_YOGURT = 11;
   private static final int MIN_INPUT = 1;
   private static final int MAX_INPUT = 200;
   
   public static int gaussianSum(int n) {
      int gaussianSum = 0;
      for (int x = 1; x <= n; x++) {
         gaussianSum = gaussianSum + x;
      }    
      return gaussianSum;
      
   }
   
   public static int factorial(int num) {
      int factorial;
      factorial = 1;
      for (int x = 1; x <= num; x++) {
         factorial = factorial * x;
      }
      return factorial;
      
   }
       
   public static void main(String[] args)
   {
      Scanner inputStream = new Scanner(System.in);
      String userInputStr, decision, decision2;
      int numStamps, yogurtCount, integerResponse;
      
      // initialize variables
      numStamps = 0;
      yogurtCount = 0;
           
      // Main loop
      while (KEEP_LOOPING) {
         
         // print menu
         System.out.println(OPTIONS);
         System.out.println(PURCHASE_CHOICE);
         System.out.println(SHUT_DOWN_CHOICE);
         
         
         // prompt user response
         System.out.println(USER_CHOICE);
         decision = inputStream.nextLine().toUpperCase();
         
         if (decision.charAt(0) == CALCULATE) { 
            
          
           

   
            
            System.out.println(MATHEMATICAL_PROMPT);
            decision2 = inputStream.nextLine().toUpperCase();
            
            if (decision2.charAt(0) == FACTORIAL) {
               System.out.println(INTEGER_PROMPT);
               userInputStr = inputStream.nextLine();
              integerResponse = Integer.parseInt(userInputStr);
               if (integerResponse < MIN_INPUT) {
                  System.out.println(INVALID_INPUT);
               } else if (integerResponse > MAX_INPUT) {
                  System.out.println(INVALID_INPUT);
               } else {
                  System.out.println(factorial(integerResponse));
               }
               

            } else if (decision2.charAt(0) == GAUSSIAN) {
               System.out.println(INTEGER_PROMPT);
               userInputStr = inputStream.nextLine();
               integerResponse = Integer.parseInt(userInputStr);
               if (integerResponse < MIN_INPUT) {
                  System.out.println(INVALID_INPUT);
               } else if (integerResponse > MAX_INPUT) {
                  System.out.println(INVALID_INPUT);
               } else {
                  System.out.println(gaussianSum(integerResponse));
               }
        
               
               
            } else { 
               System.out.println(BAD_LETTER_MSG2);
               continue;
            }
                  

                   
         } else if (decision.charAt(0) == SHUT_DOWN) {
            System.out.println(SHUT_DOWN_MSG);
            inputStream.close();
            System.exit(1);
         } else {
            System.out.println(BAD_LETTER_MSG);
         }
         
      } // end main loop
      
   } 
   
}

/* -------------------------------- run ------------------------------------
Calculate or Shut Down?
(user inputs C or S, respectively)
(if the user inputs a value that is not C or S, display an error code and restart the program)

Factorial or Gaussian Sum?

(user inputs F or G, respectively)
(if the user inputs a value that is not F or G, display an error code and restart the program)

Prompt user to enter an integer.
(A user cannot enter a negative number, A user cannot enter an integer that is greater than 200)

Print value.

---------------------------------------------------------------------------- */
