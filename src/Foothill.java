// Lab #4
// Jordan Cheng

import java.util.Scanner;

public class Foothill
{
   private static final String BAD_LETTER_MSG = " *** Use P or S please *** ";
   private static final String SHUT_DOWN_MSG = "Shutting down... Bye!";
   private static final char SHUT_DOWN = 'S';
   private static final String INVALID_RESPONSE = " *** Invalid response *** ";
   private static final String INVALID_YOGURTS = 
         " *** Invalid number of yogurts *** ";
   // define constants
   private static final String NUM_YOGURT_PURCHASED = 
         "How many yogurts would you like to buy? ";
   private static final char NO = 'N';
   private static final char YES = 'Y';
   private static final char PURCHASE = 'P';
   private static final String MENU = "Menu:";

   static final boolean KEEP_LOOPING = true;
   static final int FREE_FROZEN_YOGURT = 11;
   static final String INDENT = "   ";
   private static final String SHUT_DOWN_CHOICE = INDENT + "S (Shut Down)";
   private static final String PURCHASE_CHOICE = 
         INDENT + "P (Process Purchase)";
   static final String SEPARATOR = "\n";
   private static final String QUALIFIED_FOR_FREE_YOGURT = 
         SEPARATOR + "You qualify for a free "
         + "yogurt. " + "Would you like to use your "
            + "credits? (Y or N)";
   private static final String USER_CHOICE = SEPARATOR + "Your choice:";
   static final int MIN_ORDER = 0;
       
   public static void main(String[] args)
   {
      Scanner inputStream = new Scanner(System.in);
      String userInputStr, decision, freeYogurtResponse;
      int numStamps, yogurtCount;
      
      // initialize variables
      numStamps = 0;
      yogurtCount = 0;
      decision = " ";
           
      // Main loop
      while (KEEP_LOOPING) {
         
         // print menu
         System.out.println(MENU);
         System.out.println(PURCHASE_CHOICE);
         System.out.println(SHUT_DOWN_CHOICE);
         
         // prompt user response
         System.out.println(USER_CHOICE);
         decision = inputStream.nextLine().toUpperCase();
         
         if (decision.charAt(0) == PURCHASE) { 
            
            if (numStamps >= FREE_FROZEN_YOGURT) {
               
               // initialize or clear any previous value of free yogurt response
               // freeYogurtResponse = " ";
               
               System.out.println(QUALIFIED_FOR_FREE_YOGURT);
               freeYogurtResponse = inputStream.nextLine().toUpperCase();
               
               // Using credits/stamps
               if (freeYogurtResponse.charAt(0) == YES) {
                  
                  numStamps = numStamps - FREE_FROZEN_YOGURT;
                  System.out.println("You have just used " +
                        FREE_FROZEN_YOGURT + 
                     " stamps and have " + numStamps + " stamps left" +
                     SEPARATOR + "Enjoy your free yogurt." + SEPARATOR);
                  
               } else {
             
                  if (freeYogurtResponse.charAt(0) == NO) {
                     // Not using credits/stamps
                     
                     System.out.println(NUM_YOGURT_PURCHASED);
                     userInputStr = inputStream.nextLine();
                     yogurtCount = Integer.parseInt(userInputStr);
                     
                     if (yogurtCount < MIN_ORDER) {
                        System.out.println(INVALID_YOGURTS);
                        continue;
                     } else {
                        numStamps = numStamps + yogurtCount;
                        System.out.println("You just earned " + yogurtCount +
                           " stamps and have a total of " + numStamps + 
                           " stamps to use."); 
                     }
                    //must answer yes or no
                  } else {
                  
                     System.out.println(INVALID_RESPONSE);
                  }
               }
               
            } else { // Unqualified for free frozen yogurt
            
               System.out.println(NUM_YOGURT_PURCHASED);
               userInputStr = inputStream.nextLine();
               yogurtCount = Integer.parseInt(userInputStr);
               
               if (yogurtCount < MIN_ORDER) {
                  System.out.println(INVALID_YOGURTS);
                  continue;
               } else {
                  numStamps = numStamps + yogurtCount;
                  System.out.println("You just earned " + yogurtCount + 
                        " stamps and have a total of " + numStamps + 
                        " stamps to use.");
               
               }
            }
         } else {   // response is to not Purchase
            if (decision.charAt(0) == SHUT_DOWN) {
               System.out.println(SHUT_DOWN_MSG);
               inputStream.close();
               System.exit(1);
            } else {
               System.out.println(BAD_LETTER_MSG);
            }
         }
                
      } // end main loop
      
   } 
   
}

/* -------------------------------- run #1  --------------------------------
Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
P
How many yogurts would you like to buy? 
1
You just earned 1 stamps and have a total of 1 stamps to use.
Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
p
How many yogurts would you like to buy? 
2
You just earned 2 stamps and have a total of 3 stamps to use.
Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
Pond
How many yogurts would you like to buy? 
3
You just earned 3 stamps and have a total of 6 stamps to use.
Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
pond
How many yogurts would you like to buy? 
4
You just earned 4 stamps and have a total of 10 stamps to use.
Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
P r I e S t
How many yogurts would you like to buy? 
50
You just earned 50 stamps and have a total of 60 stamps to use.
Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
pARTy

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
Y
You have just used 11 stamps and have 49 stamps left
Enjoy your free yogurt.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
P

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
yawning noises
You have just used 11 stamps and have 38 stamps left
Enjoy your free yogurt.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
p

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
Nada
How many yogurts would you like to buy? 
-5
 *** Invalid number of yogurts *** 
Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
Neither option
 *** Use P or S please *** 
Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
123
 *** Use P or S please *** 
Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
sup dudes!
Shutting down... Bye!
---------------------------------------------------------------------------- */

/* -------------------------------- run #2  --------------------------------
Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
ping pong
How many yogurts would you like to buy? 
456
You just earned 456 stamps and have a total of 456 stamps to use.
Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
pass the milk

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
Yes sir!
You have just used 11 stamps and have 445 stamps left
Enjoy your free yogurt.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
P

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
No
How many yogurts would you like to buy? 
asdf
Exception in thread "main" java.lang.NumberFormatException: For input string: "asdf"
   at java.lang.NumberFormatException.forInputString(Unknown Source)
   at java.lang.Integer.parseInt(Unknown Source)
   at java.lang.Integer.parseInt(Unknown Source)
   at Foothill.main(Foothill.java:85)
---------------------------------------------------------------------------- */
