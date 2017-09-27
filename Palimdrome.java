/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Palimdrome;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author kavunnuggihalli
 */
public class Palimdrome {
    
    public static Stack<String> palimdroms = new Stack<>();
    
    public static void main(String [] args){
        
        System.out.println("Welcome to Palimdrome");
        System.out.println("Please enter words enter quit to exit");
        System.out.println("");
        
        Scanner keys = new Scanner(System.in);
        int x = 0;//for while loop
        
        while(x == 0){
            String word = keys.next().toLowerCase();
            if("quit".equals(word)){x=1;}else{//if not quitting
                System.out.println(isPalimdrome(word));//check if word is palimdrome
            }//end of else
        }//end of while
        
        //the user just quit
        System.out.println("");
        System.out.println("You just Quit here are all your Palimdroms");
        for(int i=0; i<palimdroms.size+1; i++){
             System.out.println(palimdroms.pop());
        }
        
    }//end of main
    
    public static Boolean isPalimdrome(String s){
        Queue<Character> wForward = new Queue<>();
        Stack<Character> wBackward = new Stack<>();
        
        int amt = 0;
        
        int length = s.length();
        
        for(int i=0; i<length; i++){//stack a word backwards
            wBackward.push(s.charAt(i));
            wForward.enqueue(s.charAt(i));
        }

        for(int i=0; i<length; i++){//check if palimdrome
            if(Objects.equals(wForward.dequeue(), wBackward.pop())){
                amt++;
            }
        }
        
        if(amt == length){
            palimdroms.push(s);
            return true;
        }else{
            return false;
        }
    }
}
