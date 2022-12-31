package com.driver;

public class BankAccount {

    public static class AccountNumberException extends Exception{        
        AccountNumberException(){
            super("Account Number can not be generated");
        }
    }

    public static class InsufficientBalanceException extends Exception {
        InsufficientBalanceException(){
            super("InsufficientBalanceException");
        }
    }

    private String name;
    private double balance;
    private double minBalance;
    private boolean isPossible;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
        this.isPossible = false;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        int[] arr = new int[digits];
        generate(sum, arr, 0);

        if( isPossible == false ){
            throw new AccountNumberException();
        }
        return null;
    }

    public  void generate( int sum, int[] arr, int indx  ){
	    
        if( indx == arr.length ){
            int digitSum  = 0;
            for( int val : arr ){
                digitSum += val;
            }
            if( sum == digitSum ){
                isPossible = true;
            }
            return;
        }
        for( int i=0; i<=9; i++ ){
            if( arr[indx] == 0 ){
                arr[indx] = i;
                generate( sum, arr, indx + 1);
                arr[indx] = 0;
            }
        } 
     }

    public void deposit(double amount) {
        //add amount to balance
        balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        double temp  = balance;
        if( (temp -= amount) < minBalance ){
            throw new InsufficientBalanceException();
        }
        else{
            balance -= amount;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    

}