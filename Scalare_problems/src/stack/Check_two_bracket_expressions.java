package stack;

import java.util.Arrays;
import java.util.Stack;

/*Problem Description

Given two strings A and B. Each string represents an expression consisting of lowercase english alphabets, '+', '-', '(' and ')'.

The task is to compare them and check if they are similar. If they are similar return 1 else return 0.

NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’ and every operand appears only once.



Problem Constraints

1 <= length of the each String <= 100



Input Format

The arguments given are string A and String B.



Output Format

Return 1 if they represent the same expression else return 0.



Example Input

Input 1:

 A = "-(a+b+c)"
 B = "-a-b-c"
Input 2:

 A = "a-b-(c-d)"
 B = "a-b-c-d"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B. 
Explanation 2:

 Both the expression are different.*/

public class Check_two_bracket_expressions {
	public static void main(String[] args) {
		String A = "-(-(-(-a+b)-d+c)-q)";
		String B = "a-b-d+c+q";
        int[] v = new int[26];
        int[] v1 = new int[26];
 
        // Put signs of all operands in expr1
        eval(A, v, true);
 
        // Subtract signs of operands in expr2
        eval(B, v1, false);
      System.out.println(Arrays.equals(v, v1));
	}
	 static void eval(String s, int[] v, boolean add)
	    {
	 
	        // stack stores the global sign
	        // for operands.
	        Stack<Boolean> stk = new Stack<>();
	        stk.push(true);
	 
	        // + means true
	        // global sign is positive initially
	 
	        int i = 0;
	        while (i < s.length())
	        {
	            if (s.charAt(i) == '+' || s.charAt(i) == '-')
	            {
	                i++;
	                continue;
	            }
	            if (s.charAt(i) == '(')
	            {
	 
	              
	                if (adjSign(s, i))
	                    stk.push(stk.peek());
	                else
	                    stk.push(!stk.peek());
	            }
	 
	            
	            else if (s.charAt(i) == ')')
	                stk.pop();
	 
	            else
	            {
	 
	                if (stk.peek()) {
	                	if(adjSign(s, i) == true) {
	                		 v[s.charAt(i) - 'a'] +=1;
	                	}
	                	else {
	                		 v[s.charAt(i) - 'a'] -=1;
	                	}
	                }
	                    
	 
	                // global sign is negative here
	                else {
	                	if(adjSign(s, i) == true) {
	               		 v[s.charAt(i) - 'a'] -=1;
	               	}
	               	else {
	               		 v[s.charAt(i) - 'a'] +=1;
	               	}
	                	
	                }
	                   
	            }
	            i++;
	        }
	    };
	    static boolean adjSign(String s, int i)
	    {
	        if (i == 0)
	            return true;
	        if (s.charAt(i - 1) == '-')
	            return false;
	        return true;
	    }

}
