/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

import java.util.Arrays;
import java.util.Random;

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
    
   public int binarySearch(int start, int end, int target, int checks){
       checks++;
       int middle = (start+end)/2;
       
       if(data[middle].equals(target)){
           System.out.println("Took "+checks+" checks to find.");
           return middle;
       }
       else if (start >= end) {
           return -1;
       }
       else if(((Comparable)data[middle]).compareTo(target) > 0){
           return binarySearch(start, middle-1, target, checks);
       }else {
           return binarySearch(middle+1,end,target,checks);
       }
       
   }
   
   public int linearSearch(int target){
       int checks = 0;
       int spot = -1;
       for(int i=0;i<count;i++){
           if(data[i].equals(target)){
               spot = i;
               break;
           }
           else if(spot == -1){
               checks++;
           }
       }
       System.out.println("Took "+checks+" checks to find.");
       return spot;
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
    
    public void sort(){
        Arrays.sort(data);
    }
    
   
    
    
    public static void main(String args[]){
        
        
         try{
            ArrayManager am = new ArrayManager();
          
            Random r = new Random();
            
            for(int i=0;i<1000;i++){
                am.add(r.nextInt(10000));
            }
            
            am.sort();
            
            int targetPos = am.binarySearch(0, am.data.length, 1000, 0);
            
            if(targetPos != -1){
            System.out.println("Position: "+targetPos+" Value: "+am.getElementAt(targetPos));
            }else{
                System.out.println("Not Found.");
            }
            
         }catch(OutOfBoundsException oobe){
             
         }
      
        
       
    }

  

  
    
}
