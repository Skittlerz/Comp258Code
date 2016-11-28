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
public abstract class Person {
    private String firstName;
    private String lastName;
    private char middleInit;

    public Person(){}
    
    public Person(String first, String last, char middle){
        setFirstName(first);
        setLastName(last);
        setMiddleInit(middle);
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the middleInit
     */
    public char getMiddleInit() {
        return middleInit;
    }

    /**
     * @param middleInit the middleInit to set
     */
    public void setMiddleInit(char middleInit) {
        this.middleInit = middleInit;
    }
    
}
