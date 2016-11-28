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
public class ChequingAccount extends BankAccount {
    private float overDraftLimit;
    private float overDraftPenalty;

    public ChequingAccount(){}
    
    public ChequingAccount(int accountNo, float balance, float overDraftLimit, 
            float overDraftPenalty){
        super(accountNo, balance);
        setOverDraftLimit(overDraftLimit);
        setOverDraftPenalty(overDraftPenalty);
    }
    /**
     * @return the overDraftLimit
     */
    public float getOverDraftLimit() {
        return overDraftLimit;
    }

    /**
     * @param overDraftLimit the overDraftLimit to set
     */
    public void setOverDraftLimit(float overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    /**
     * @return the overDraftPenalty
     */
    public float getOverDraftPenalty() {
        return overDraftPenalty;
    }

    /**
     * @param overDraftPenalty the overDraftPenalty to set
     */
    public void setOverDraftPenalty(float overDraftPenalty) {
        this.overDraftPenalty = overDraftPenalty;
    }
    
    public void withdraw(float amount) throws Exception{
        //TO DO
        if (this.getBalance() > amount){
            this.setBalance(this.getBalance() - amount);
        }else if ((this.getBalance()+this.getOverDraftLimit()) > amount){
            this.setBalance(this.getBalance()-(amount+overDraftPenalty));
            //= overDraftPenalty;
        }else{
            throw new Exception();
        }
        
        
    }
    
    
    }
    
    

