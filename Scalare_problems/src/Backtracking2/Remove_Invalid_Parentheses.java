package Backtracking2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/*Problem Description

Given a string A consisting of lowercase English alphabets and parentheses '(' and ')'. Remove the minimum number of invalid parentheses in order to make the input string valid.

Return all possible results.

You can return the results in any order.



Problem Constraints

1 <= length of the string <= 20



Input Format

The only argument given is string A.



Output Format

Return all possible strings after removing the minimum number of invalid parentheses.



Example Input

Input 1:

 A = "()())()"
Input 2:

 A = "(a)())()"


Example Output

Output 1:

 ["()()()", "(())()"]
Output 2:

 ["(a)()()", "(a())()"]


Example Explanation

Explanation 1:

 By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 4 then string becomes : "()()()"
        2. Remove the parentheses at index 2 then string becomes : "(())()"
Explanation 2:

 By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 5 then string becomes : "(a)()()"
        2. Remove the parentheses at index 2 then string becomes : "(a())()"
*/
public class Remove_Invalid_Parentheses {
	static HashSet<String>set;
    static ArrayList<String> temp;
	public static void main(String[] args) {
		   String A = "()())()";
		   set = new HashSet<>();
	        temp =  new ArrayList<>();
	        int removal = isValid(A);
	        check(A, removal);
	       System.out.println(temp);
		
	}
	
	 static void check(String A, int removal){
	        if(removal == 0){
	            if(isValid(A) == 0){
	                temp.add(A);
	            }
	            return;
	        }

	        for(int i = 0 ; i<A.length(); i++){
	            String left = A.substring(0,i);
	            String right = A.substring(i+1);
	            String total = left+right;
	            if(set.contains(total))continue;
	            set.add(total);
	            check(total, removal-1);
	        }
	    }

	 static int isValid(String A){
	     Stack<Character> st = new Stack<Character>();
	     for(int i = 0; i<A.length(); i++){
	         char c = A.charAt(i);
	         if(c == '('){
	             st.push('(');
	         }
	         else if( c == ')'){
	             if(st.size() == 0 || st.peek() == ')'){
	                 st.push(')');
	             }
	             else{
	                 st.pop();
	             }
	         }
	     }
	     return st.size();
	 }


}
