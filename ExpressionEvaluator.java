
package eg.edu.alexu.csd.datastructure.stack.cs;

import java.util.ArrayList;

public class ExpressionEvaluator implements IExpressionEvaluator {
    stack operator=new stack();
     String[] temp;
     static int count;
     static int realsize;
     @Override
	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* @param expression
	* infix expression
	* @return postfix expression
	*/
    public String infixToPostfix(String expression){
        count=0;
        realsize=0;
        ArrayList<String> numbers = new ArrayList<String>();
        numbers=checkconvert(expression);
        temp=new String[numbers.size()];
        String c;
        int i=0;
        String value=null;
        for(i=0;i<numbers.size();i++){
            c=numbers.get(i);
             if(!"+".equals(c)&&!"-".equals(c)&&!"/".equals(c)&&!"*".equals(c)&&!"(".equals(c)&&!")".equals(c)){
                temp[count]=c;
                count++;
            }else if("+".equals(c)||"-".equals(c)){
              if(!operator. isEmpty()){
                if("*".equals((String)operator.peek())||"/".equals((String)operator.peek())){
                 temp[count]=(String)operator.pop();
                 count++;
                 while((!operator. isEmpty())&&(("+".equals((String)operator.peek())||"-".equals((String)operator.peek())))){
                    temp[count]=(String)operator.pop();
                    count++;
                    }
                 operator.push(c);    
                }else {       
                temp[count]=(String)operator.pop(); 
                count++;
                operator.push(c);
                }
              }else{
                operator.push(c);  
                }
                
            }else if("*".equals(c)||"/".equals(c)){
                if(!operator. isEmpty()){
                    if("-".equals((String)operator.peek())||"+".equals((String)operator.peek())){
                       operator.push(c);
                    }else {
                        temp[count]=(String)operator.pop();
                        operator.push(c);
                        count++;
                    }
                }else{
                  operator.push(c);  
                }
            }
            else if("(".equals(c)){ 
            i=bracketcheck(i,numbers);      
            }
                
        
        }
        while(!operator. isEmpty()){
            if(!"(".equals((String)operator.peek())){
            temp[count]=(String)operator.pop();
            count++;
            }else{
                operator.pop();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        i=0;
        while(i<temp.length&&temp[i]!=null) {
            stringBuilder.append(temp[i]+" ");
            i++;
            realsize++;
        }
        value=stringBuilder.toString();
          return value;
    }
    /**
	* it is special method to deal with values inside Parenthesis
	* @param start
        * the start index of Parenthesis in expression
        * @param numbers
        *arraylist which contain expression 
	* @return the last index the method reach
	*/
    public int bracketcheck(int start,  ArrayList<String> numbers){
        String c;
        int i=start; 
        c=numbers.get(i);
        operator.push(c);
        while(!")".equals(c)){
          i++;
           c=numbers.get(i);
           if(!"+".equals(c)&&!"-".equals(c)&&!"/".equals(c)&&!"*".equals(c)&&!"(".equals(c)&&!")".equals(c)){
                temp[count]=c;
                count++;
           }else if("+".equals(c)||"-".equals(c)){
              if(!"(".equals((String)operator.peek())){
                if("*".equals((String)operator.peek())||"/".equals((String)operator.peek())){
                 temp[count]=(String)operator.pop();
                 count++;
                 while((!operator. isEmpty())&&("+".equals((String)operator.peek())||"-".equals((String)operator.peek()))){
                    temp[count]=(String)operator.pop();
                    count++;
                    }
                 operator.push(c);    
                }else {       
                temp[count]=(String)operator.pop(); 
                count++;
                operator.push(c);
                }
              }else{
                operator.push(c);  
                }                
            }else if("*".equals(c)||"/".equals(c)){
                if(!"(".equals((String)operator.peek())){
                    if("+".equals((String)operator.peek())||"-".equals((String)operator.peek())){
                        operator.push(c);
                    }else {
                        temp[count]=(String)operator.pop();
                        operator.push(c);
                        count++;
                    }
                }else{
                  operator.push(c);  
                }
            }
            else if("(".equals(c)){ 
            i=bracketcheck(i,numbers);      
            }
        }
        while(!"(".equals((String)operator.peek())){
            temp[count]=(String)operator.pop();
            count++;
        }
        operator.pop();
        return i;
    }
    @Override
	/**
	* Evaluate a postfix numeric expression
	* @param expression
	* infix expression
	* @return the expression evaluated value
	*/
    public int evaluate(String expression){
        count=0;
        infixToPostfix(expression);
        ArrayList<String> numbers = new ArrayList<String>();
        numbers=checkconvert(expression);
        stack n1=new stack();
        String c;int i=0;
        int number;
        float num1;float num2;
        float result=0;
        while(i<realsize){
            c=temp[i];
           if(!"+".equals(c)&&!"-".equals(c)&&!"/".equals(c)&&!"*".equals(c)){
                number=Integer.parseInt(c);
               n1.push((float)number);
            }else{
                num1=(float)n1.pop();
                num2=(float)n1.pop();
                switch (c) {
                    case "+":
                        result=num2+num1;
                        n1.push(result);
                        break;
                    case "-":
                        result=num2-num1;
                        n1.push(result);
                        break;
                    case "*":
                        result=num2*num1;
                        n1.push(result);
                        break;
                    case "/":
                        if(num1!=0){
                        result=num2/num1;
                        n1.push(result);
                        }
                        else{
                            throw new RuntimeException("divide by zero");
                        }
                        break;
                    default:
                        break;
                }
            }
            i++;
        }
        return (int)result;
    }
    /**
	* check the expression if it is a vaild equation 
	*then
        * convert the expression to String array list
	* @param expression
        * infix expression
	* @return arraylist of the expression
	*/
    public ArrayList<String> checkconvert(String expression){
        char c;
        int i=0;
        int start=0;
        int end=1;
        Boolean status=true;
        String num;
        ArrayList<String> numbers = new ArrayList<String>();
        Boolean check=check(expression);
        if(check){
        while(i<expression.length()){
            start = i;
            c = expression.charAt(i);
            while (i < expression.length()&&c != ' ' && c != '/' && c != '*' && c != '+' && c != '-' && c != '(' && c != ')') {
                i++;
                end = i;
                if(i < expression.length()){
                c = expression.charAt(i);
                }
                status=false;
            }
            num = expression.substring(start, end);
            numbers.add(num);
            if(status){
            i++;}
            status =true;
            end = 1 + i;
       }
      while(numbers.contains(" ")){
          numbers.remove(" ");
      }
     }else{
          throw new RuntimeException("invalid equation");
      }
        return numbers; 
    }
     /**
	* check the expression if it is a valid equation
	* @param expression
        * infix expression
	* @return Boolean of the status of the equation if it is correct or not
	*/
    public Boolean check(String expression){
        int i=0;
        char c =0;
        Boolean check=false;
        for(i=0;i<expression.length();i++){
          c=expression.charAt(i);
          if((c>= '0' && c <= '9')|| (c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')||c == ' ' || c == '/' ||c == '*'|| c == '+' || c == '-' || c == '(' || c == ')'){
          check=true;
          }else{
           check=false;
           break;
          }
        }
        return check;
    }
        
}

    
