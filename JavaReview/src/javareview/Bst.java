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
public class Bst {
    
    public Node start;
   
    
    public Bst(){}
    
    public void add(int data){
        
        if (start == null) {
            start = new Node(data);
        } else {
            addNode(start, data);
 
        }
    }
    
    public void addNode(Node current, Comparable data) {
       
        
        if (data.compareTo(current.getData()) <= 0) {
           
            if (current.left == null) {
                current.left = new Node(data);
            } else {
                addNode(current.left, data);
            }
        } else{
            
          if (current.right == null) {
                current.right = new Node(data);
            } else {
                addNode(current.right, data);
            }
       }
 
    }
 
    public boolean searchTree(Comparable data) {
        return searchTree(start, data, 0);
 
    }
 
    public boolean searchTree(Node current, Comparable data, int calls) {
        calls++;
        if (current.getData().compareTo(data) == 0) {
            System.out.println(calls + " Searches");
            return true;
        } else if (data.compareTo(current.getData()) < 0 && current.left != null) {
            return searchTree(current.left, data, calls);
        } else if (data.compareTo(current.getData()) > 0 && current.right != null) {
            return searchTree(current.right, data, calls);
        } else {
            System.out.println(calls + " Searches");
            return false;
        }
 
    }
 
    public void printTree() {
        printTree(start);
    }
 
    public void printTree(Node node) {
        if (node.left != null) {
            printTree(node.left);
        }
        System.out.println(node.getData());
 
        if (node.right != null) {
            printTree(node.right);
        }
    }
    
    public void delete(Node current, Comparable target){
    
            boolean isRight = false;
            Node nodeToDelete = null;
            if(current.getData().compareTo(target)>=0 
                    && current.left!=null ){
                
                if(current.left.getData().compareTo(target)==0)
                {
                    System.out.println("Parent found: "+current.getData());
                    nodeToDelete = current.left;
                }
                else{
                   delete(current.left, target);
                }
                
            }
            else if(current.getData().compareTo(target)<0 
                    && current.right!=null)
            {
                if(current.right.getData().compareTo(target)==0)
                {
                    System.out.println("Parent found: "+current.getData());
                    isRight=true;
                    nodeToDelete = current.right;                        
                }
                else{
                    delete(current.right, target);
                }
            }
            else{
               System.out.println("node found: "+current.getData() );
            }
            
            
            if(nodeToDelete != null){
                //Case 1.
                if(nodeToDelete.left==null && nodeToDelete.right==null)
                {
                        if(isRight)
                            current.right=null;
                        else
                            current.left=null;
                }
                //Case 2.
                else if(nodeToDelete.right==null){
                    if( isRight)
                        current.right = nodeToDelete.left;
                    else
                        current.left = nodeToDelete.left;
                }
                //Case 3.
                else if(nodeToDelete.right.left==null){
                    nodeToDelete.right.left=nodeToDelete.left;
                    current.right = nodeToDelete.right;
                }
                //Case 4. 
                else if(nodeToDelete.right.left!=null){
                    
                    Node leftMost = findLeftMostNode(nodeToDelete.right);
                    deleteLeftMostNode(nodeToDelete.right);
                    
                    System.out.println("Current:"+ current.getData());
                    System.out.println("Node To Delete:"+ nodeToDelete.getData());
                    System.out.println("Left Most:"+ leftMost.getData());
                    leftMost.right = nodeToDelete.right;
                    current.left = leftMost;
                }
            }
    }
    
    public Node findLeftMostNode( Node node){
        
        if(node.left==null)
            return node;
        else
            return findLeftMostNode(node.left);
        
    }
    
    public Node findRightMostNode(Node node){
        
        if(node.right==null)
            return node;
        else
            return findRightMostNode(node.right);
    }
    
    public void deleteLeftMostNode(Node node){
        
        if(node.left.left==null)
            node.left=null;
        else
            deleteLeftMostNode(node.left);
    }
    
    public void deleteRightMostNode(Node node){
        
        if(node.right.right==null)
            node.right=null;
        else
            deleteRightMostNode(node.right);
    }
      
    
    public void delete(Comparable target){
        delete(start, target);
    }
//    
//    public void delete(Node current, Comparable target){
//        
//        boolean isRight = false;
//        Node nodeToDelete = null;
//        //System.out.println(current.getData());
//        //Result: 50
//    
//        //if data is greater than target 
//        if(current.getData().compareTo(target)>0 && current.left != null )
//        {
//                
//            if(current.left.getData().compareTo(target)==0)
//            {
//                System.out.println("Left Parent found: "+current.getData());
//                nodeToDelete = current.left;
//                System.out.println("Node to delete: "+ current.left.getData());
//            }
//            else
//            {
//                delete(current.left, target);
//                //System.out.println("current.left else triggered");
//            }
//                
//        }else if(current.getData().compareTo(target)<0 && current.right != null)
//        {
//                
//            if(current.right.getData().compareTo(target)==0)
//                {
//                    System.out.println(" Right Parent found: "+current.getData());
//                    isRight = true;
//                    nodeToDelete = current.right;
//                        
//                }
//            else
//                {
//                    delete(current.right, target);
//                    //System.out.println("current.right else triggered");
//                }
//        }else
//        {
//            System.out.println("node found: "+current.getData() );
//        }
//        
//        
//        if(nodeToDelete != null)
//        {
//            if(nodeToDelete.left == null && nodeToDelete.right == null)
//            {
//                //System.out.println("Left Parent found: "+ current.getData());
//                
//                if(isRight)
//                {
//                    current.right = null;
//                }
//                else
//                {
//                    current.left = null;
//                    //nodeToDelete = null; 
//                }
//            }
//            else if(nodeToDelete.right == null)
//            {
//                if(isRight)
//                {
//                    current.right = nodeToDelete.left;
//                }
//                else
//                {
//                    current.left = nodeToDelete.left;
//                }
//            }
//            //nodeToDelete = null;    
//        }
//    }
    
    public static void main(String args[]){
        
        Bst bst = new Bst();
        
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(13);
        bst.add(35);
        bst.add(66);
        bst.add(85);
        bst.add(17);
        bst.add(63);
        bst.add(90);
        bst.add(15);
        bst.add(18);
        
        bst.printTree();
        System.out.println("===========================");
        bst.delete(63);
        bst.delete(35);
        bst.printTree();
    }
    
      class Node {
 
        private Comparable data;
        public Node left;
        public Node right;
 
        public Node() {
 
        }
 
        public Node(Comparable data) {
            setData(data);
        }
 
        public void setData(Comparable data) {
            this.data = data;
        }
 
        public Comparable getData() {
            return data;
        }
    }
}
