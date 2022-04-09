package DP6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Equal_Average_Partition {
	
	 static boolean[][][] dp;
	  static Vector < Integer > res = new Vector < > ();
	  static int[] original;
	  static int total_size;
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(7);
		A.add(15);
		A.add(29);
		A.add(11);
		A.add(9);
		Vector < Vector < Integer >> sol = partition(A);
	    ArrayList < ArrayList < Integer > > ans = new ArrayList < ArrayList < Integer > > (2);
	    for (int i = 0; i < sol.size(); i++) {
	      ArrayList < Integer > a = new ArrayList < Integer > ();
	      for (int j = 0; j < sol.elementAt(i).size(); j++) {
	        a.add(sol.elementAt(i).elementAt(j));
	      }
	      ans.add(new ArrayList < Integer > (a));
	    }
	    System.out.println(ans);
	}
	
	static boolean possible(int index, int curr_sum,
		    int curr_size) {

		    // base cases 
		    if (curr_size == 0)
		      return (curr_sum == 0);
		    if (index >= total_size)
		      return false;

		    // Which means curr_sum cant be found for curr_size 
		    if (dp[index][curr_sum][curr_size] == false)
		      return false;

		    if (curr_sum >= original[index]) {
		      res.add(original[index]);

		      // Checks if taking this element at 
		      // index i leads to a solution 
		      if (possible(index + 1, curr_sum - original[index],
		          curr_size - 1))
		        return true;

		      res.remove(res.size() - 1);
		    }

		    // Checks if not taking this element at 
		    // index i leads to a solution 
		    if (possible(index + 1, curr_sum, curr_size))
		      return true;

		    // If no solution has been found 
		    return dp[index][curr_sum][curr_size] = false;
		  }

		  // Function to find two Partitions having equal average 
		  static Vector < Vector < Integer >> partition(ArrayList < Integer > A) {
		    int[] Vec = new int[A.size()];
		    for (int i = 0; i < A.size(); i++)
		      Vec[i] = A.get(i);
		    // Sort the vector 
		    Arrays.sort(Vec);
		    original = Vec;
		    res.clear();

		    int total_sum = 0;
		    total_size = Vec.length;

		    for (int i = 0; i < total_size; ++i)
		      total_sum += Vec[i];

		    // building the memoization table 
		    dp = new boolean[original.length][total_sum + 1][total_size];

		    for (int i = 0; i < original.length; i++)
		      for (int j = 0; j < total_sum + 1; j++)
		        for (int k = 0; k < total_size; k++)
		          dp[i][j][k] = true;

		    for (int i = 1; i < total_size; i++) {

		      // Sum_of_Set1 has to be an integer 
		      if ((total_sum * i) % total_size != 0)
		        continue;
		      int Sum_of_Set1 = (total_sum * i) / total_size;

		      // We build our solution vector if its possible 
		      // to find subsets that match our criteria 
		      // using a recursive function 
		      if (possible(0, Sum_of_Set1, i)) {

		        // Find out the elements in Vec, not in 
		        // res and return the result. 
		        int ptr1 = 0, ptr2 = 0;
		        Vector < Integer > res1 = res;
		        Vector < Integer > res2 = new Vector < > ();
		        while (ptr1 < Vec.length || ptr2 < res.size()) {
		          if (ptr2 < res.size() &&
		            res.elementAt(ptr2) == Vec[ptr1]) {
		            ptr1++;
		            ptr2++;
		            continue;
		          }
		          res2.add(Vec[ptr1]);
		          ptr1++;
		        }

		        Vector < Vector < Integer >> ans = new Vector < > ();
		        ans.add(res1);
		        ans.add(res2);
		        return ans;
		      }
		    }

		    // If we havent found any such subset. 
		    Vector < Vector < Integer >> ans = new Vector < > ();
		    return ans;
		  }

}
