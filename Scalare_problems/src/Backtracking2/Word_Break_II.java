package Backtracking2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*Given a string A and a dictionary of words B, add spaces in A to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

Note : Make sure the strings are sorted in your result.

Input Format:

The first argument is a string, A.
The second argument is an array of strings, B.
Output Format:

Return a vector of strings representing the answer as described in the problem statement.
Constraints:

1 <= len(A) <= 50
1 <= len(B) <= 25
1 <= len(B[i]) <= 20
Examples:

Input 1:
    A = "b"
    B = ["aabbb"]

Output 1:
    []

Input 1:
    A = "catsanddog",
    B = ["cat", "cats", "and", "sand", "dog"]

Output 1:
    ["cat sand dog", "cats and dog"]
*/
public class Word_Break_II {
	static HashSet<String> set;
	public static void main(String[] args) {
		String A = "catsanddog";
		ArrayList<String> B = new ArrayList<>();
		
		ArrayList<String> result = new ArrayList<>();
		B.add("cat");
		B.add("cats");
		B.add("and");
		B.add("sand");
		B.add("dog");
		set = new HashSet<>(B);
		StringBuffer buffer = new StringBuffer();
		
		check(A, B, result, "");
		 Collections.sort(result);
		System.out.println(result);
		
	}
	
	static void check(String A , ArrayList<String> B,  ArrayList<String> result, String ans){
		if(A.length() == 0) {
			result.add(ans.trim());
			return ;
		}
			
		for(int i = 0; i<A.length(); i++) {
			String left = A.substring(0, i+1);
			if(B.contains(left)) {
				String right = A.substring(i+1);
				check(right, B, result, ans+left+" ");
				
			}
				
		}
		
	}

}
