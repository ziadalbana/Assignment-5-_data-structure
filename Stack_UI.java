/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.stack.cs;

import java.util.Scanner;

/**
 *
 * @author ZIAD ALBANA 
 */
public class Stack_UI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        stack s1=new stack();
        Scanner input=new Scanner(System.in);
       do{ 
        do{
            System.out.println("1: Push");
            System.out.println("2: Pop");
            System.out.println("3: Peek");
            System.out.println("4: Get size");
            System.out.println("5: Check if empty");
            System.out.println("0: to Exit");
            choice=input.nextInt();
        }while(choice<0||choice>5);
        switch (choice) {
            case 1:
                System.out.println("enter the element");
                Object element;
                element=input.next();
                s1.push(element);
                break;
            case 2:
                System.out.println(s1.pop());
                break;
            case 3:
                System.out.println("peek:"+s1.peek());
                break;
            case 4:
                System.out.println("size:"+s1.size());
                break;
            case 5:
                System.out.println("status: "+s1.isEmpty());
                break;
            default:
                break;
        }
    }while(choice!=0);
   }
    
}
