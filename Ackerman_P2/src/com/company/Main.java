package com.company;

class SavingsAccount{
    public static double annualInterestRate = 0.0;

    private double savingsBalance;

    public SavingsAccount(double savingsBalance){
        this.savingsBalance =  savingsBalance;
    }

    public void showBalance(){
        System.out.printf("$%.2f", this.savingsBalance);
    }

    public void calculateMonthlyInterest(){
        double interest;
        interest = this.savingsBalance * (annualInterestRate / 100) / 12;
        this.savingsBalance += interest;
    }

    public static void modifyInterestRate(double newInterestRate){
        annualInterestRate = newInterestRate;
    }
}

public class Main{
    public static void main(String[] args){

        SavingsAccount.modifyInterestRate(4.0);
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);

        int i;

        System.out.println("Month \t\t Saver1 \t Saver2");

        for(i=1; i<=12; ++i){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.print("Month " + i + ": \t");
            saver1.showBalance();
            System.out.print("\t");
            saver2.showBalance();
            System.out.println();
        }

        System.out.println();
        System.out.println("Interest Rate At 5%");
        System.out.println();
        SavingsAccount.modifyInterestRate(5.0);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.print("Month 13: \t");
        saver1.showBalance();
        System.out.print("\t");
        saver2.showBalance();
    }
}