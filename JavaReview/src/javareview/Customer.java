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
public class Customer extends Person {
    private int customerID;

    public Customer() {
        super();
    }
    
    public Customer(String first, String last, char middle, int id){
        super(first, last, middle);
        setCustomerID(id);
    }
    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
