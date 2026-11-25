import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {

      int bal = 100000;
      boolean runningTrans = true;
      boolean continueTrans = true;

      Scanner scan = new Scanner(System.in) ;

      do {
        System.out.println("\n==== Welcome to the MelTrust Bank! ====\n");
        System.out.println("\nB - Check for Balance"); 
        System.out.println("D - Make Deposit");
        System.out.println("W - Make Witdrawal");
        System.out.println("Q - Quit");
        System.out.print ("Select an option: ");

        String userOption = scan.nextLine().trim();
        char choice = ' ';
        char userOptionChar = ' ';
        boolean validChoice = false;

        if (userOption.length() == 1) {
          userOptionChar = Character.toUpperCase(userOption.charAt(0)) ;
          if (userOptionChar == 'B' || userOptionChar == 'D' || userOptionChar == 'W' || userOptionChar == 'Q') {
              choice = userOptionChar;
              validChoice = true;
          }
        }

        if (!validChoice) {
          System.out.println("Invalid entry, enter any valid option: B/D/W/Q");
          continue;
        }

        switch (choice) {
          case 'B':
            System.out.println("\nChecking Balance..."); 
            break;
          case 'D':
            System.out.println("\n==== Deposit ===="); 
            break;
          case 'W':
            System.out.println("\n==== Withdraw ===="); 
            break;
          case 'Q': System.out.println("\n==== Exiting Program... ===="); 
            break;
          default:
            System.out.println("\n==== Invalid entry, enter any valid option: B/D/W/Q ====");
            break;
        }
      } while (continueTrans && runningTrans);

      System.out.println("Want to transact another? (Y/N)");
      scan.close();

    }
}