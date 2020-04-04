/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.stack.cs;

/**
 *
 * @author Alex
 */
public class linkedlist {
     Node head;
     Node tail;
   private int size=0;
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
   
    public class Node{
    Object data;
    Node next;
    Node(Object data){
        this.data=data;
        next=null;
    }
}
    public void addfirst(Object data){
        Node add=new Node(data);
        if(head==null){
            head=add;
            size++;
        }else{
            add.next=head;
            head=add;
            size++;
        }
    }
    public Object removefirst(){
        Object temp=null;
        if(size==0){
          System.out.println("overflow error");
        }else{
            temp=head.data;
            head=head.next;
            size--;
        }
        return temp;
    }
     public  void print(){
        Node current=head;
        System.out.println("Linkedlist:");
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
     }   
    
}
