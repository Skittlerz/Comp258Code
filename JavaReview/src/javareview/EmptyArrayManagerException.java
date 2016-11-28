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
public class EmptyArrayManagerException extends OutOfBoundsException {
    private String operation;
    
    public EmptyArrayManagerException(){
        System.out.println("Empty array manager exception created");
        operation = "operation not defined";
    }
    
     public EmptyArrayManagerException(String operation){
        System.out.println("Empty array manager exception created.");
        this.operation = operation;
    }
    public String getMessage(){
        return("Your array manager is empty. Unable to " + operation);
    }
}
