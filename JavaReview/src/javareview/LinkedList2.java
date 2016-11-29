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
public class LinkedList2<T extends Comparable> {
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
            current.next = new Node2(t);
            current = current.next;
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
    
    public T findMax(){
        T max = start.getData();
        Node2<T> temp = start;
        
        for(int i =1; i<count;i++){
        
            if( max.compareTo( temp.getData() )<0  ){

                max = temp.getData();
            }
            
            temp = temp.next;
        }
        
        return max;
    }
    
 
    
    //Nested Inner Class Node2
    //Stores objects for linked list
    class Node2<T extends Comparable>{

        public Node2<T> next;

        private T data;

        public Node2(){}

        public Node2(T data){
            setData(data);
        }


        public T getData(){
            return data;
        }

        public void setData(T data){
            this.data = data;
        }
    }
    
    public static void main(String[] args){

	LinkedList2<Integer> list = new LinkedList2<Integer>();

		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(50);
		list.add(11);
		list.add(12);

		list.printList();

		Integer x = list.findMax();
		System.out.println(x);

	}
}
