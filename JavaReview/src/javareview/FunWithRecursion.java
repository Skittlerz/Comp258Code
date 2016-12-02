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
public class FunWithRecursion {
    
    public static int AddEmUp(int num){
        //works towards base case
        if(num == 1){
            return num;
        }else{
            //calls itself
            return num + AddEmUp(num-1);
        }
       
    }

public static void main(String args[]){
    System.out.println(AddEmUp(4));
}    
}
