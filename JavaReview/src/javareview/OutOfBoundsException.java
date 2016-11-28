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
public class OutOfBoundsException extends Exception{
    
    public OutOfBoundsException(){
        System.out.println("Out of Bounds Exception created");
    }
    
    public String getMessage(){
        return("An index was referenced outside the bounds of the array.");
    }
}
