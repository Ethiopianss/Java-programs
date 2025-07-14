/* 
 *  ##Best if it's run in the CMD, powershell or any other command Line interface (Linux)
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class GroupBank {
    public static void main(String[] args) {
        // Opening up accounts
        System.out.println("How many accounts would you like to open");
        Scanner input2 = new Scanner(System.in);
        int m = input2.nextInt();
        bank D[] = new bank[m];
        int abc = 0;
        for (int i = 0; i < D.length; i++) {
            System.out.println("");
            System.out.println((++abc) + "# Account Opening");
            System.out.println("");
            D[i] = new bank();
            D[i].createAccount();

        }
        // Showing accounts
        System.out.println("Would you like to display all created accounts\nPress 1 --> Yes\nPress 2 --> No");
        int responseDisplay = input2.nextInt();
        if (responseDisplay==1) {
          for (int i = 0; i<D.length;i++)
              D[i].showAccounts();
            System.out.println("------------------------------------");
            System.out.println("");
        } 
        
        // withdrawing Money
        System.out.println("Would you like to withdraw or Deposit money\nPress 1 --> Yes\nPress 2 -->No");
        int reply = input2.nextInt();
        if (reply==1) {
            System.out.println("Money withdraw and Deposit\nPress 1 --> withdraw\npress 2 --> deposit\nThen press Enter");
        int withdrawOrDeposit = new Scanner(System.in).nextInt();
        if (withdrawOrDeposit == 1) {
            System.out.print("Type your PIN ");
            int PINwithdraw = new Scanner(System.in).nextInt();
            System.out.print("Amount to withdraw: ");
            long amountWithdraw = new Scanner(System.in).nextLong();
            bank.withdraw(PINwithdraw, amountWithdraw, D);
        }
        // Depositing Money
        else if (withdrawOrDeposit == 2) {
            System.out.print("Type your PIN ");
            int PINdeposit = new Scanner(System.in).nextInt();
            System.out.print("Amount to Deposit ");
            long amountDeposit = new Scanner(System.in).nextLong();
            bank.Deposit(PINdeposit, amountDeposit, D);
        }
        }
        
        // Showing account details
        System.out.println("-----------------------------------");
        System.out.println("Would you like to see your account details\nPress 1--> Yes\nPress 2 --> No");
        int response = input2.nextInt();
        if (response == 1) {
            System.out.println("Type your PIN, to show your account details");
            int PINdetails = new Account().fourDigit();
            System.out.println();
            Account.showDetails(PINdetails, D);



        }
        //Removing Accounts
        System.out.println("Would you like to delete your account\nPress 1 --> yes\nPres 2 --> no");
        int removeNumber = input2.nextInt();
        if (removeNumber ==1) {
            input2.nextLine();
            System.out.println("Type your PIN");
            int PIN = input2.nextInt();
            bank.removeAccounts(D,PIN);

        }


//        for(int i =0; i<D.length;i++){
//            D[i].showAccounts();
//            System.out.println("---------------------------------------");
//        }
    }
}

class bank {
     public int PIN;
     public long accountNumber;
     public String name;
     public String accountType;
     public long balance;
    Scanner AccountMaker = new Scanner(System.in);

    // Opening a Bank Account
    public void createAccount() {
        PIN = fourDigit();
        accountNumber = tenDigits();
        System.out.print("Enter Account Type: ");
        AccountMaker.nextLine(); // To clear the buffer of newline so I can take the whole input form account
                                 // type
        accountType = AccountMaker.nextLine();
        System.out.print("Enter a name: ");
        name = AccountMaker.nextLine();
        System.out.print("Enter Balance: ");
        balance = AccountMaker.nextLong();
    }

    // Checking whether the PIN is four digits or not
    int fourDigit() {
        System.out.print("Type your PIN,, 4 numbers maximum ");
        PIN = AccountMaker.nextInt();
        boolean AA1 = false;
        while (AA1 == false) {
            if (PIN < 1000 || PIN > 9999) {
                System.out.println("Invalid PIN, try again");

                PIN = AccountMaker.nextInt();
                AA1 = false;
            }
            AA1 = true;

        }

        return PIN;
    }

    // Making sure the account number is 10 digits
    long tenDigits() {
        System.out.println("Type your account number, it should be 10 digits");
        accountNumber = AccountMaker.nextLong();
        boolean aa1 = true;
        while (aa1) {
            if (accountNumber < 1000000000 || accountNumber > 9999999999L ) {
                System.out.println("number of digits isn't 10, try again");
                accountNumber = AccountMaker.nextLong();
            } 
            else {
                aa1 = false;
            }
        }
        return accountNumber;

    }

    // Displaying All accounts
    public  void showAccounts() {
        System.out.println("------------------------------------");

            System.out.println("Account's owner: " + name);
            System.out.println("Account number: " + accountNumber);
            // System.out.println("Account Type: "+accountType);
            System.out.println("Balance : " + balance + "ETB");
            // System.out.println("Personal Identification Number - PIN : "+PIN);
            System.out.println("");


    }

    // Money withdraw
    static boolean foundPIN = false;
    static void withdraw(int key, long amount, bank[] a) {
        for (bank account : a) {
            if (account.PIN == key) {
                if (account.balance >= amount) {
                    account.balance -= amount;
                    System.out.println("Successful withdraw " + amount+" Birr from Account name: "+account.name);
                    foundPIN =true;
                    break;
                } else {
                    System.out.println("insufficient Balance");
                }
            }
        }
        if(foundPIN==false)
        {
            System.out.println("Invalid PIN, try again");
        }
    }

    static void Deposit(int key, long amount, bank[] a) {

        for (bank acc : a) {
            if (acc.PIN == key) {
                acc.balance += amount;
                System.out.println("Successful Deposit to Account name  "+acc.name+"\nCurrent Balance: "+acc.balance);
                foundPIN =true;
                break;
            }
        }
        if (foundPIN==false){
            System.out.println("Invalid PIN");
        } }


    static void removeAccounts( bank[] array, int PIN){
        //Converting the Array to an ArrayList
        ArrayList<bank> removedAccount = new ArrayList<>(Arrays.asList(array));
//        iterating over the Array to find Account's PIN matching the PIN that request deletion
        boolean  accountFound= false;
        for (int i = 0; i<removedAccount.size(); i++ ){

            if (removedAccount.get(i).PIN==PIN){
                removedAccount.remove(i);
                System.out.println("Account with PIN "+PIN+" is removed");
                accountFound=true;
            }
        }
        if (accountFound==false){
            System.out.println("Account with PIN "+PIN+" isn't found");
        }
//            Showing the All the current Accounts
//        for (int i = 0; i<removedAccount.size(); i++){
//            removedAccount.get(i);
//        }

       }

}

class Account extends bank {
    static void showDetails(int PIN, bank[] b) {
        for (bank account : b) {
            if (PIN == account.PIN) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Account's owner: " + account.name);
                System.out.println("Account number: " + account.accountNumber);
                System.out.println("Account Type: " + account.accountType);
                System.out.println("Balance : " + account.balance + "ETB");
                System.out.println("Personal Identification Number - PIN : " + PIN);
                System.out.println("-------------------------------------------------------------");

            }
            

        }
 
    }
   
}
