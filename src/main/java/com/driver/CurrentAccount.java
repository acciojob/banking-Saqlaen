package com.driver;

public class CurrentAccount extends BankAccount{

    public static class ValidLicenseException extends Exception {
        ValidLicenseException(){
            super("Valid License can not be generated");
        }
        
    }
    String tradeLicenseId; //consists of Uppercase English characters only

    boolean possible;

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super( name, balance, 5000d );
        this.tradeLicenseId = tradeLicenseId;
        possible = false;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        checkRearranged( tradeLicenseId, "" );
        
        if( possible == false ){
            throw new ValidLicenseException();
        }

    }

    public void checkRearranged( String str, String output ){

        if( str.length() == 0 ){
            if( idCheck( output ) ){
                possible = true;
            }
            return; 
        }
        for( int i=0; i<str.length(); i++ ){
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i+1);
            String ans = left + right;
            checkRearranged( ans , output + ch );
        }
    }

    public boolean idCheck( String str ){
        for( int i=1; i<str.length(); i++ ){
            if( str.charAt(i) == str.charAt(i-1) ){
                return false;
            }
        }
        return true;
    }

}
