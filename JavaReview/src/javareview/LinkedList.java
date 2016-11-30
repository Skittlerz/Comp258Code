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
public class LinkedList{
    
    Node items;
    Node current;
    
    public LinkedList(){}
    
    public void add(Object i){
        
        if(items==null){
            items = new Node(i);
            current = items;
        }else {
            Node temp = new Node(i);
            current.next = temp;
            current = temp;
        }
    }
    
    public void addAfter(Object o){
         if(items==null){
            items = new Node(o);
            current = items;
        }else {
             Node temp = new Node(o);
             temp.next = current.next;
             current.next = temp;
             current = temp;
         }
    }
    
    public void addBefore(Object o){
        Node add = new Node(o);
        Node temp = items;
        while(temp.next != current){
            temp = temp.next;
        }
       add.next = current;
       temp.next = add;
    }
    
    public Node getNodeAt(int i){
        Node temp = items;
        
        for(int count=0;count<i;count++){
            temp= temp.next;
        }
        
        return temp;
       
    }
    
    public void start(){
        current = items;
    }
    
    public void advance(){
        current = current.next;
    }
    
    public Object getCurrent(){
        return current.getData();
    }
    
    public void removeCurrent(){
        if(current == items){
            items = items.next;
            current = items;
        }else if(current != null){
            Node temp = items;
            
            while(temp.next != current){
                temp = temp.next;
            }
            
            temp.next = current.next;
            current = temp;
        }
    }
    
     public void removeRange(int start, int end){
         
         Node temp1 = items;
         Node temp2 = items;
         
         for(int i=1; i<start-1;i++){
            temp1 = temp1.next;
         }
        
        for(int i=1; i<=end; i++){
            temp2 = temp2.next;
        }
        
        temp1.next = temp2;
    }
    
    public void printList(){
        
        Node temp = items;
        
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
