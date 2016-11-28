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
public class SavingsAccount extends BankAccount {
    
    private float minBalance;
    private int withdrawCount;
    private final static float ACTIVITY_PENALTY = 5f;
    private final static int ACTIVITY_LIMIT = 10;
    
    
    
    public SavingsAccount(){}
    
    public SavingsAccount(int accountNo, float balance, float minBalance, 
                          int withdrawCount){
        super(accountNo, balance);
        setMinBalance(minBalance);
        setWithdrawCount(withdrawCount);
    }
    
    /**
     * @return the minBalance
     */
    public float getMinBalance() {
        return minBalance;
    }

    /**
     * @param minBalance the minBalance to set
     */
    public void setMinBalance(float minBalance) {
        this.minBalance = minBalance;
    }

    /**
     * @return the withdrawCount
     */
    public int getWithdrawCount() {
        return withdrawCount;
    }

    /**
     * @param withdrawCount the withdrawCount to set
     */
    public void setWithdrawCount(int withdrawCount) {
        this.withdrawCount = withdrawCount;
    }
    
    public void withdraw(float amount) throws Exception{
        float fee=0;
        
        if(getBalance() < minBalance && withdrawCount > ACTIVITY_LIMIT){
            fee = ACTIVITY_PENALTY;
        }
        
        if ((amount + fee) <= this.getBalance()){
            this.setBalance(this.getBalance()-(amount+fee));
            setWithdrawCount(withdrawCount++);
        }else {
            throw new Exception();
        }
        
        
    }
    
}
