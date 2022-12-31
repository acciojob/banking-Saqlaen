package com.driver;

public class SavingsAccount extends BankAccount{

    public static class MaxWitdrawException extends Exception {
        MaxWitdrawException(){
            super("Maximum Withdraw Limit Exceed");
        }
    }

    

    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }
    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    private double rate;
    private double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super( name, balance, 0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
 
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if( amount > maxWithdrawalLimit ){
            throw new MaxWitdrawException();
        }
        else{
            super.withdraw(amount);
        }


    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double principle = getBalance();
        double r = this.rate;
        double t = (double) years;
        return principle * (1+(t * r)) ;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double n = (double) times;
        double r = rate;
        double t = (double) years;
        double principle = getBalance();
        return principle *  Math.pow( (1 + (r / n)), n * t); 
    }

}
