import java.util.Scanner;

interface Bank 
{
    void deposit(double amount);
    void displayBalance();
    void withdraw(double amount);
}

class Account 
{
    String name;
    int accountNumber;
    String accountType;
    double balance;

    Account(String name, int accountNumber, String accountType, double initialBalance) 
    {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    // Method to get the balance
    public double getBalance() 
    {
        return balance;
    }
}

class SavAcct extends Account implements Bank 
{
    double interestRate;

    SavAcct(String name, int accountNumber, double initialBalance, double interestRate) 
    {
        super(name, accountNumber, "Savings", initialBalance);
        this.interestRate = interestRate;
    }

    public void deposit(double amount) 
    {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void displayBalance() 
    {
        System.out.println("Current balance: " + getBalance());
    }

    public void computeAndDepositInterest() 
    {
        double interest = getBalance() * interestRate;
        balance += interest;
        System.out.println("Interest of " + interest + " added. New balance: " + getBalance());
    }

    public void withdraw(double amount) 
    {
        if (amount > getBalance()) 
        {
            System.out.println("Insufficient funds.");
        } 
        else 
        {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". New balance: " + getBalance());
        }
    }
}

class CurAcct extends Account implements Bank 
{
    double minBalance = 500.0;
    double serviceCharge = 50.0;

    CurAcct(String name, int accountNumber, double initialBalance) 
    {
        super(name, accountNumber, "Current", initialBalance);
    }

    public void deposit(double amount) 
    {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void displayBalance() 
    {
        System.out.println("Current balance: " + getBalance());
    }

    public void withdraw(double amount) 
    {
        if (amount > getBalance()) 
        {
            System.out.println("Insufficient funds.");
        } 
        else 
        {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". New balance: " + getBalance());
        }
        checkMinimumBalance();
    }

    void checkMinimumBalance() 
    {
        if (getBalance() < minBalance) 
        {
            balance -= serviceCharge;
            System.out.println("Service charge imposed. New balance: " + getBalance());
        }
    }
}

public class BankAccount 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();
        
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        
        System.out.println("Choose account type (1 for Savings, 2 for Current): ");
        int accountType = scanner.nextInt();

        Bank account;
        if (accountType == 1) 
        {
            System.out.println("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            System.out.println("Enter interest rate (as a decimal): ");
            double interestRate = scanner.nextDouble();
            account = new SavAcct(name, accountNumber, initialBalance, interestRate);
        } 
        else 
        {
            System.out.println("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            account = new CurAcct(name, accountNumber, initialBalance);
        }

        account.displayBalance();
        
        // Immediate interest calculation for savings account
        if (account instanceof SavAcct) 
        {
            ((SavAcct) account).computeAndDepositInterest(); 
        }

        System.out.println("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
        account.displayBalance();

        System.out.println("Enter withdrawal amount: ");
        double withdrawalAmount = scanner.nextDouble();
        account.withdraw(withdrawalAmount);
        account.displayBalance();

        scanner.close();
    }
}
