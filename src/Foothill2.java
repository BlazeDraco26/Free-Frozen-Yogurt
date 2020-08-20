// Lab #4
// Jordan Cheng

import java.util.Scanner;

public class Foothill2
{
   // define constants
   private static final char SHUT_DOWN = 'S';
   private static final char PURCHASE = 'P';
   private static final char NO = 'N';
   private static final char YES = 'Y';
   
   private static final String INDENT = "   ";  
   private static final String SEPARATOR = "\n"; 
   
   private static final String MENU = "Menu:";
   private static final String SHUT_DOWN_CHOICE = INDENT + SHUT_DOWN 
                                                               + " (Shut Down)";
   private static final String PURCHASE_CHOICE = INDENT + PURCHASE
                                                       + " (Process Purchase)";
   private static final String USER_CHOICE = SEPARATOR + "Your choice:";  
   private static final String BAD_LETTER_MSG = " *** Use " + PURCHASE + " or "
                                       + SHUT_DOWN + " please *** " + SEPARATOR;
   private static final String NUM_YOGURT_PURCHASED = 
                                    "How many yogurts would you like to buy? ";
   private static final String INVALID_RESPONSE = " *** Invalid response *** "
                                                                  + SEPARATOR;
   private static final String INVALID_YOGURTS = 
                                          " *** Invalid number of yogurts *** "
                                                                   + SEPARATOR;
   private static final String QUALIFIED_FOR_FREE_YOGURT = 
                                 "You qualify for a free yogurt. " 
                                       + "Would you like to use your "
                                          + "credits? (Y or N)";
   private static final String SHUT_DOWN_MSG = "Shutting down... Bye!";
   
   private static final boolean KEEP_LOOPING = true;
   
   private static final int FREE_FROZEN_YOGURT = 11;
   private static final int MIN_ORDER = 0;
       
   public static void main(String[] args)
   {
      Scanner inputStream = new Scanner(System.in);
      String userInputStr, decision, freeYogurtResponse;
      int numStamps, yogurtCount;
      
      // initialize variables
      numStamps = 0;
      yogurtCount = 0;
           
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
               
               System.out.println(QUALIFIED_FOR_FREE_YOGURT);
               freeYogurtResponse = inputStream.nextLine().toUpperCase();
               
               if (freeYogurtResponse.charAt(0) == YES) {
                  
                  numStamps = numStamps - FREE_FROZEN_YOGURT;
                  System.out.println("You have just used " +
                        FREE_FROZEN_YOGURT + " stamps and have " + numStamps 
                           + " stamps left" + SEPARATOR + SEPARATOR 
                           + "Enjoy your free yogurt." + SEPARATOR);
                  continue;
                  
               } else if (freeYogurtResponse.charAt(0) != NO) {
                
                  // Free Yogurt response is not Y or N so invalid
                  System.out.println(INVALID_RESPONSE); 
                  continue;
                  
               }   
            }
            
            // Choose not to use free yogurt credits or 
            // Unqualified for free yogurt
            
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
                  " stamps to use." + SEPARATOR); 
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

/* -------------------------------- run #1  --------------------------------

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
p
How many yogurts would you like to buy? 
1
You just earned 1 stamps and have a total of 1 stamps to use.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
P
How many yogurts would you like to buy? 
2
You just earned 2 stamps and have a total of 3 stamps to use.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
P o P p Y sEED
How many yogurts would you like to buy? 
5
You just earned 5 stamps and have a total of 8 stamps to use.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
pr un e jUICE
How many yogurts would you like to buy? 
77
You just earned 77 stamps and have a total of 85 stamps to use.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
P
You qualify for a free yogurt. Would you like to use your credits? (Y or N)
yass plz
You have just used 11 stamps and have 74 stamps left

Enjoy your free yogurt.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
P
You qualify for a free yogurt. Would you like to use your credits? (Y or N)
nah
How many yogurts would you like to buy? 
0
You just earned 0 stamps and have a total of 74 stamps to use.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
P
You qualify for a free yogurt. Would you like to use your credits? (Y or N)
yam i am
You have just used 11 stamps and have 63 stamps left

Enjoy your free yogurt.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
none
 *** Use P or S please *** 

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
pro sk8s
You qualify for a free yogurt. Would you like to use your credits? (Y or N)
oops
 *** Invalid response *** 

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
phone my lawyer
You qualify for a free yogurt. Would you like to use your credits? (Y or N)
No.
How many yogurts would you like to buy? 
-9
 *** Invalid number of yogurts *** 

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
pride
You qualify for a free yogurt. Would you like to use your credits? (Y or N)
no
How many yogurts would you like to buy? 
56
You just earned 56 stamps and have a total of 119 stamps to use.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
pond
You qualify for a free yogurt. Would you like to use your credits? (Y or N)
no survivors
How many yogurts would you like to buy? 
75
You just earned 75 stamps and have a total of 194 stamps to use.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
second option
Shutting down... Bye!

---------------------------------------------------------------------------- */

/* -------------------------------- run #2  --------------------------------

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
poke a haunt us
How many yogurts would you like to buy? 
-9
 *** Invalid number of yogurts *** 

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
poor man's hand
How many yogurts would you like to buy? 
1
You just earned 1 stamps and have a total of 1 stamps to use.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
thank you
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
P
How many yogurts would you like to buy? 
15
You just earned 15 stamps and have a total of 16 stamps to use.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
P
You qualify for a free yogurt. Would you like to use your credits? (Y or N)
yipper
You have just used 11 stamps and have 5 stamps left

Enjoy your free yogurt.

Menu:
   P (Process Purchase)
   S (Shut Down)

Your choice:
sorry about that
Shutting down... Bye!

---------------------------------------------------------------------------- */
