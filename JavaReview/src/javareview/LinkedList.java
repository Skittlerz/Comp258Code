/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

import java.util.Stack;

/**
 *
 * @author braun1792
 */
public class LinkedList{
    
    Node front;
    Node current;
    
    public LinkedList(){}
    
    public Boolean isEmpty(){
        return front == null;
    }
    
    public void add(Object i){
        
        if(isEmpty()){
            front = new Node(i);
            current = front;
        }else {
            Node temp = new Node(i);
            current.next = temp;
            current = temp;
        }
    }
    
    public void addAfter(Object o){
         if(isEmpty()){
            front = new Node(o);
            current = front;
        }else {
             Node temp = new Node(o);
             temp.next = current.next;
             current.next = temp;
             current = temp;
         }
    }
    
    public void addBefore(Object o){
        Node add = new Node(o);
        Node temp = front;
        while(temp.next != current){
            temp = temp.next;
        }
       add.next = current;
       temp.next = add;
    }
    
    public Node getNodeAt(int i){
        Node temp = front;
        
        for(int count=0;count<i;count++){
            temp= temp.next;
        }
        
        return temp;
       
    }
    
    public void front(){
        current = front;
    }
    
    public void advance(){
        current = current.next;
    }
    
    public Object getCurrent(){
        return current.getData();
    }
    
    public void removeCurrent(){
        if(current == front){
            front = front.next;
            current = front;
        }else if(current != null){
            Node temp = front;
            
            while(temp.next != current){
                temp = temp.next;
            }
            
            temp.next = current.next;
            current = temp;
        }
    }
    
     public void removeRange(int start, int end){
         
        Node temp1 = front;
        Node temp2 = front;
         
        for(int i=1; i<start-1;i++){
            temp1 = temp1.next;
        }
        
        for(int i=1; i<=end; i++){
            temp2 = temp2.next;
        }
        
        temp1.next = temp2;
    }
    
    public void printList(){
        
        Node temp = front;
        
        while(temp!=null){
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }
  
    public static void main(String args[]){
        
        LinkedList list = new LinkedList();
        
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        
        list.printList();
        list.start();
        list.advance();
        list.advance();
        System.out.println(">>"+list.getCurrent());
        list.addAfter(99);
        list.printList();
        System.out.println(">>"+list.getCurrent());
        list.removeCurrent();
        list.printList();
        System.out.println(">>"+list.getCurrent());
        list.addBefore(88);
        list.printList();
        System.out.println(">>"+list.getCurrent());
        list.removeRange(2, 4);
        list.printList();
        
       
    }

public class Node {
    
    private Object data;
    public Node next;
    
    public Node(){};
    public Node(Object data){
        setData(data);
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
}
}
