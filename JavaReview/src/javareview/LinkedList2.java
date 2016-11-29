/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

/**
 *
 * @author acb
 */
public class LinkedList2<T> {
    private Node2<T> start;
    private Node2<T> current;
    int count;
    
    public LinkedList2(){
        count=0;
    }
    
    public void add(T t){
        if(start==null){
            start = new Node2(t);
            current = start;
        }
        else{
            Node2 temp = new Node2(t);
            current.next = temp;
            current = temp;
        }
        count++;
    }
 
    public void printList(){
        
        Node2 temp = start;
        
        while( temp!=null){
            System.out.println(temp.getData());
            temp=temp.next;
        }
     
    }
    
 
    
    //Nested Inner Class Node2
    //Stores objects for linked list
    class Node2<T>{

        public Node2<T> next;

        private T data;

        public Node2(){}

        public Node2(T data){
            setData(data);
        }


        public Object getData(){
            return data;
        }

        public void setData(T data){
            this.data = data;
        }
    }
}
