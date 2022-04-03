package DP6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Problem Description

Given a string A, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of A = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings A and B of the same length, determine if B is a scrambled string of S.



Problem Constraints

1 <= len(A), len(B) <= 50



Input Format

The first argument of input contains a string A.

The second argument of input contains a string B.



Output Format

Return 1 if true, 0 if false



Example Input

Input 1:

 A = "we"
 B = "we"
Input 2:

 A = "phqtrnilf"
 B = "ilthnqrpf"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 
It is the same string.


Explanation 2:

 There is no way to achieve B from A.*/

public class Scramble_String {
	static Map<String, Boolean> map;

	public static void main(String[] args) {
		map = new HashMap<>();
	    String s1 = "we";
	    String s2 = "we";
		if (s1.length() != s2.length())
			System.out.println(0);

		if (s1.length() == 0 && s2.length() == 0)
			System.out.println(1);

		boolean k = memoized(s1, s2);
		if (k)
			System.out.println(1);
		else
			System.out.println(0);

	}
	
	static boolean memoized(String s1, String s2) {
		if (s1.equals(s2))
	            return true;

	        if (s1.length() <= 1)return false;
	        
	        String c1 = s2, c2 = s2;
	        char[] a1 = c1.toCharArray();
	        char[] a2 = c2.toCharArray();
	        
	        Arrays.sort(a1);
	        Arrays.sort(a2);
	        
	        c1 = new String(a1);
	        c2 = new String(a2);
	        
	        if(!c1.equals(c2))
	        {
	            return false;
	        }
	        
	        
	        String key = s1 + " "  + s2;
	        if (map.containsKey(key))
	            return map.get(key);

	        int n = s1.length();
	        boolean flag = false;
	        for (int i = 1; i <= n-1; i++)
	        {
	            boolean condswap = memoized(s1.substring(0, i), s2.substring(n-i)) && memoized(s1.substring(i), s2.substring(0,n-i));
	            boolean condNOTswap = memoized(s1.substring(0, i), s2.substring(0, i)) && memoized(s1.substring(i), s2.substring(i));

	            if (condswap ||condNOTswap)
	            {
	                flag=true;break;
	            }

	        }

	        map.put(key, flag);
	        return flag;
	}

}
