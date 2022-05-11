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
import java.util.Scanner;
public class ParenMatch{
    
public static void main (String[] args){   
Stack s = new Stack();
String line; // the string of characters to be checked

Scanner scan = new Scanner(System.in);
System.out.println ("\nParenthesis Matching");
System.out.print ("Enter a parenthesized expression: ");
line = scan.nextLine();
// loop to process the line one character at a time
// print the results
int length = line.length();
boolean extraParen = false;
int i;
for (i = 0; i < length; i++) {
    char c = line.charAt(i);
    
    if (c == '(') {
        s.push(c);
    }
    else if (c == ')') {
        if(s.isEmpty()) {
            extraParen = true;
            break;
        }
        else {
            s.pop();
        }
    }
}
    
    if (extraParen) {
        System.out.println("Too many right parenthesis: " + line.substring(0, i + 1));
    }
    else if (!s.isEmpty()) {
        System.out.println("Too many left parenthesis: " + line);
    }
    else {
        System.out.println("Matching parenthesis");
    }
}
}





