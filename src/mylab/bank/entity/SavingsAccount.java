package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println(interest + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
        System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + balance + "원");
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("잔액이 부족합니다.");
        }
        balance -= amount;
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
    }

    @Override
    public String toString() {
        return super.toString() + ", 이자율: " + interestRate + "%";
    }
}