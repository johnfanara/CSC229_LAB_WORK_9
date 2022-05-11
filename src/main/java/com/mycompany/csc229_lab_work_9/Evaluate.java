/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc229_lab_work_9;

/**
 *
 * @author johnf
 */
import java.util.*;

public class Evaluate {
    public static double evaluate(String expression) {
        char[] token = expression.toCharArray();
        Stack<Double> vals = new Stack<Double>();
        Stack<Character> ops = new Stack<Character>();
        int tokenLen = token.length;
        
        for (int i = 0; i < tokenLen; i++) {
            if (token[i] == ' ') {
                continue;
            }
            
            if (token[i] >= '0' && token[i] <= '9') {
                StringBuffer buff = new StringBuffer();
                while (i < tokenLen && token[i] >= '0' && token[i] <= '9') {
                    buff.append(token[i++]);
                }
                vals.push(Double.parseDouble(buff.toString()));
                i--;
            }
            
            else if (token[i] == '(') {
                ops.push(token[i]);
            }
            
            else if (token[i] == ')') {
                while (ops.peek() != '(') {
                    
                    vals.push(applyOp(ops.pop(), vals.pop(), vals.pop()));
                }
                ops.pop();
            }
            
            else if (token[i] == '+' || token[i] == '-' ||
                     token[i] == '*' || token[i] == '/') {
                while(!ops.empty() && hasPrecedence(token[i], ops.peek())) {
                    vals.push(applyOp(ops.pop(), vals.pop(), vals.pop()));
                }
                ops.push(token[i]);
            }
        }

        while (!ops.empty()) {
            vals.push(applyOp(ops.pop(), vals.pop(), vals.pop()));
        }
        return vals.pop();
    }
 
   
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        else {
            return true;
        }
    }
 
    public static double applyOp(char op, double b, double a) {
        switch (op) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0) {
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            }
            return a / b;
        }
        return 0;
    }
 
    public static void main(String[] args)
    {
        System.out.println(Evaluate.evaluate("(1 + ((2 - 3 ) * (14 * 5)))"));
        System.out.println(Evaluate.evaluate("((1 + sqrt (5)) / 2)"));
    }
}
