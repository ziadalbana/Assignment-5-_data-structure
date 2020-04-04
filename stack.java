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
public class stack implements IStack {
    linkedlist list=new linkedlist();
    
    @Override
	/**
	* Pushes an item onto the top of this stack.
	*
	* @param object
	* to insert
	*/
   public void push(Object data){
      list.addfirst(data);
   }
   @Override
	/**
	* Removes the element at the top of stack and returns that element.
	*
	* @return top of stack element, or through exception if empty
	*/
   public Object pop(){
       Object data;
       data=list.removefirst();
       return data;
   }
   @Override
	/**
	* Get the element at the top of stack without removing it from stack.
	*
	* @return top of stack element, or through exception if empty
	*/
   public Object peek(){
       Object data=null;
       if(list.getSize()==0){
           throw new RuntimeException("The Stack is Empty");
       }else{
       data=list.head.data;
       }
       return data;
   }
   @Override
	/**
	* Tests if this stack is empty
	*
	* @return true if stack empty
	*/

   public boolean isEmpty(){
       Boolean status=false;
       if(list.getSize()==0){
           status=true;
       }
       return status;
   }
   @Override
	/**
	* Returns the number of elements in the stack.
	*
	* @return number of elements in the stack
	*/
   public int  size(){
       return list.getSize();
   }
}
