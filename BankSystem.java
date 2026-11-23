import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
      System.out.println("\n==== Welcome to the MelTrust Bank! ====\n");
        int initialBal = 100000;
        String userOption; 
        boolean continueTrans = false;
        Scanner scan = new Scanner(System.in) ;

        do {
          System.out.println("\nB - Check for Balance"); 
          System.out.println("D - Make Deposit");
          System.out.println("M - Make Witdrawal");
          System.out.println("Q - Quit");
          System.out.print ("Select an option: ");
          userOption = scan.nextLine();
          char userOptionChar = Character.toUpperCase(userOption.charAt(0)) ;

            switch (userOptionChar) {
              case 'B':
                System.out.println("Checking Balance..."); 
                break;
              case 'D':
                System.out.println("==== Deposit ===="); 
                break;
              case 'W':
                System.out.println("==== Withdraw ===="); 
                break;
              case 'Q': System.out.println("==== Exiting Program... ===="); 
                break;
              default:
                System.out.println("Invalid Input. Enter (B/D/W/Q) only.");
                break;
            }
        } while (continueTrans);

        System.out.println("Want to transact another? (Y/N)");
        if (continueTrans) {
          System.out.println("Exiting Transaction...");
        }

        scan.close();

    }
}