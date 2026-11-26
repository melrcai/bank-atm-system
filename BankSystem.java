import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {

        int bal = 100000;
        boolean runningTrans = true;
        boolean continueTrans = true;

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\n\n==== Welcome to the MelTrust Bank! ====\n");
            System.out.println("B - Check for Balance");
            System.out.println("D - Make Deposit");
            System.out.println("W - Make Withdrawal");
            System.out.println("Q - Quit");
            System.out.print("Select an option: ");

            String userOption = scan.nextLine().trim();
            char choice = ' ';
            char userOptionChar = ' ';

            if (userOption.length() == 1) {
                userOptionChar = Character.toUpperCase(userOption.charAt(0));
                if (userOptionChar == 'B' || userOptionChar == 'D' || userOptionChar == 'W' || userOptionChar == 'Q') {
                    choice = userOptionChar;
                }
            }

            switch (choice) {
                case 'B':
                    System.out.println("Checking Balance...");
                    System.out.println("Your current balance is " + bal);
                    break;

                case 'D':
                    System.out.println("\n==== Deposit ====");
                    System.out.println("Your current balance is " + bal);
                    System.out.print("Enter amount to Deposit: ");
                    if (!scan.hasNextInt()) {
                        System.out.println("Invalid amount. Please enter a whole number.");
                        scan.nextLine();
                    } else {
                        int depositAmt = scan.nextInt();
                        scan.nextLine();

                        if (depositAmt <= 0) {
                            System.out.println("Deposit Amount must be greater than zero");
                        } else if (depositAmt > 500000) {
                            System.out.println("Deposit Amount must NOT be greater than 500,000");
                        } else {
                            bal += depositAmt;
                            System.out.println("Deposit Transaction is successfully completed.");
                            System.out.println("Your new balance is " + bal);
                        }
                    }
                    break;

                case 'W':
                    System.out.println("\n==== Withdraw ====");
                    System.out.println("Your current balance is " + bal);
                    System.out.print("Enter amount to Withdraw: ");

                    if (!scan.hasNextInt()) {
                        System.out.println("Invalid amount. Please enter a whole number.");
                        scan.nextLine();
                    } else {
                        int withdrawAmt = scan.nextInt();
                        scan.nextLine();

                        if (withdrawAmt <= 0) {
                            System.out.println("Withdrawal Amount must NOT be less than or equal to zero.");
                        } else if (withdrawAmt > bal) {
                            System.out.println("Withdrawal Amount must NOT be greater than " + bal);
                        } else if (withdrawAmt % 100 != 0) {
                            System.out.println("Withdrawal Amount must be exactly divisible by 100");
                        } else {
                            bal -= withdrawAmt;
                            System.out.println("Withdrawal Transaction is successfully completed.");
                            System.out.println("Your new balance is " + bal);
                        }
                    }
                    break;

                case 'Q':
                    System.out.println("\n==== Exiting Program... ====");
                    boolean validQuit = false;
                    while (!validQuit) {
                        System.out.print("Do you really want to terminate this program (Y/N)? ");
                        String quitInput = scan.nextLine().trim();

                        if (quitInput.length() == 1) {
                            char quitChar = Character.toUpperCase(quitInput.charAt(0));
                            if (quitChar == 'Y') {
                                System.out.println("Thank you for using the program!");
                                continueTrans = false;
                                runningTrans = false;
                                validQuit = true;
                            } else if (quitChar == 'N') {
                                continueTrans = true;
                                validQuit = true;
                            } else {
                                System.out.println("Invalid entry, enter Y or N only");
                            }
                        } else {
                            System.out.println("Invalid entry, enter Y or N only");
                        }
                    }
                    continue;

                default:
                    System.out.println("Invalid entry, enter any valid option: B/D/W/Q");
                    continue;
            }

            boolean validLoopPrompt = false;
            while (!validLoopPrompt) {
                System.out.print("\nWant to Transact another (Y/N)? ");
                String loopInput = scan.nextLine().trim();

                if (loopInput.length() == 1) {
                    char loopChar = Character.toUpperCase(loopInput.charAt(0));
                    if (loopChar == 'Y') {
                        continueTrans = true;
                        validLoopPrompt = true;
                    } else if (loopChar == 'N') {
                        System.out.println("Thank you for using the program!");
                        continueTrans = false;
                        runningTrans = false;
                        validLoopPrompt = true;
                    } else {
                        System.out.println("Invalid entry, enter Y or N only");
                    }
                } else {
                    System.out.println("Invalid entry, enter Y or N only");
                }
            }
        } while (runningTrans && continueTrans);

        scan.close();
    }
}