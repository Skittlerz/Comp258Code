/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

/**
 *
 * @author braun1792
 */
public abstract class BankAccount {
    private int accountNo;
    private float balance;
    private ArrayManager customers;
    
    public BankAccount(){}
    
    public BankAccount(int accountNo, float balance){
        setAccountNo(accountNo);
        setBalance(balance);
    }
    
    public void setCustomers(ArrayManager customers){
        this.customers = customers;
    }
    
    public ArrayManager getCustomers(){
        return this.customers;
    }

    /**
     * @return the accountNo
     */
    public int getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return the balance
     */
    public float getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    public void deposit(float amount){
        if(amount > 0){
        this.balance += amount;
        }
    }
    
    abstract void withdraw(float amount) throws Exception;
    
    public void transfer(BankAccount account, float amount) throws Exception{
        
        
        float bal = getBalance();
      
        
        withdraw(amount); 
       
         if(bal!=getBalance()) {
            account.deposit(amount);
            
        }else{
            throw new Exception();
        }
        
//        if((this.balance - amount) >= 0){
//        this.setBalance(this.getBalance()-amount);
//        account.deposit(amount);
//        }else {
//            throw new Exception();
//        }
    }
}
