package Stacks;

import java.util.Scanner;

/**
 * Created by 131111 on 8/21/2017.
 */
public class RPNCalc {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String res;
        do{
            ArrayStack<Double> numStk = new ArrayStack<Double>(Double.class,100);
            System.out.print("Enter your RPN equation: ");
            res = s.nextLine();
            if(res.equals("exit")){
                break;
            }
            String[] terms = res.split(" ");
            for(String str: terms){
                if(str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*")){
                    double a = numStk.pop(), b = numStk.pop();
                    switch (str){
                        case "+":
                            numStk.push(a+b);
                            break;
                        case "-":
                            numStk.push(b-a);
                            break;
                        case "/":
                            numStk.push(b/a);
                            break;
                        case "*":
                            numStk.push(a*b);
                            break;
                    }
                }else{
                    numStk.push(Double.parseDouble(str));
                }
            }
            System.out.println("Answer: "+ numStk.peek());
        }while(true);
    }

}
