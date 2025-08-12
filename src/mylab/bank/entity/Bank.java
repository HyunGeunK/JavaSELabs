package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.AccountNotFoundException;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    public SavingsAccount createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, balance, interestRate);
        accounts.add(account);
        System.out.println("Saving(저축) 계좌가 생성되었습니다: " + account.toString());
        return account;
    }

    public CheckingAccount createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, balance, withdrawalLimit);
        accounts.add(account);
        System.out.println("체킹 계좌가 생성되었습니다: " + account.toString());
        return account;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) throws Exception {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }
    
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws Exception {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        
        System.out.println(amount + "원이 " + fromAccountNumber + "에서 " + toAccountNumber + "로 송금되었습니다.");
    }

    public void printAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
    }
}