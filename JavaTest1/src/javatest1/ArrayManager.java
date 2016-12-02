/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest1;

import java.util.Arrays;

/**
 *
 * @author braun1792
 */
public class ArrayManager {
    
    private Object[] data;
    private int count;
    
    public ArrayManager(){
        //default array
        data = new Object[10];
        count = 0;
    }
    
    public ArrayManager(int initSize){
        data = new Object[initSize];
        count = 0;
    }
    
    public ArrayManager(Object[] data){
        setData(data);
        count = data.length;
    }
    /**
     * @return the data
     */
    public Object[] getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object[] data) {
        this.data = data;
    }
    
    public void printArray(){
        System.out.println(Arrays.toString(data));
        
        for(int i=0; i <count; i++){
            System.out.println(data[i].toString());
        }
    }
    
    public void deleteAtPosition(int pos) throws OutOfBoundsException{
        
        if(count == 0){
            throw new EmptyArrayManagerException("delete");
        }
        if(pos > count || pos < 0){
            throw new OutOfBoundsException();
        }
        
        for(int i = pos; i < count-1; i++){
            data[i] = data[i+1];
        }
        
        count--;
    }
    
   
    
    public void add(Object o){
        
        if(count >= data.length){
            Object[] temp = new Object[data.length+10];
            System.arraycopy(data,0,temp,0,data.length);
            data = temp;
        }
        data[count] = o;
        count++;
    }
    
    public void add(Object o, int pos) throws OutOfBoundsException{
        
        if(pos > count || pos < 0){
            throw new OutOfBoundsException();
        }
        //resize if needed
        if(count >= data.length){
            Object[] temp = new Object[data.length+10];
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
        //shift elements from pos to the right
        for (int i=count; i>pos; i--){
            data[i] = data[i-1];
        }
        //insert o into pos
        data[pos] = o;
        //increment count
        count++;
    }
    
    public int size(){
        return count;
    }
    
    //Question 2
    public void trim(){
        
        if(data.length > count){
            Object [] temp = new Object[count];
            
            //if this was a generic class I would use this..
            //but i guess i'll do it the long way
            //temp.copyOfRange(data,0,count);
            
            for(int i=0;i<count;i++){
                temp[i] = data[i];
            }
            
            data = temp;
        }
    }
    
    public Boolean isEmpty(){
        return(count==0);
    }
    
    public Object getElementAt(int pos) throws OutOfBoundsException{
     
        if(pos > count || pos < 0){
            throw new OutOfBoundsException();
        }
        
        return data[pos];
    }
    
    public void removeRange(int start, int end) throws OutOfBoundsException{
        
        if(count < end){
            throw new OutOfBoundsException();
        }
        
        for(int i=start; i<= end; i++){
            deleteAtPosition(i);
        }
    }
    
    public LinkedList getLinkedList(){
        LinkedList temp = new LinkedList();
        
        try{
        temp.addArray(data, 0);
        }catch(OutOfBoundsException oobe){
            oobe.getLinkedListArrayMessage();
        }
        
        return temp;
    }
    
   
    
    
    public static void main(String args[]){
        
        Object[] testData = {1,2,3,4,5};
        ArrayManager am = new ArrayManager(testData);
        am.printArray();
        
        try{
            am.deleteAtPosition(2);
            am.printArray();
            am.add(6);
            am.add(7);
            am.printArray();
            am.add(3,2);
            am.printArray();
            am.trim();
            am.printArray();
            am.trim();
            am.printArray();
            System.out.println("------------------");
            LinkedList ll;
            ll = am.getLinkedList();
            ll.printList();
        } catch(EmptyArrayManagerException eame){
            System.out.println(eame.getMessage());
        } catch(OutOfBoundsException oobe){
            System.out.println(oobe.getMessage());
        }
        
       
    }

  

  
    
}

