package Searching_II;

/*Problem Description
You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.



Problem Constraints
1 <= A <= 109

2 <= B, C <= 40000



Input Format
The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.



Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.



Example Input
Input 1:

 A = 1
 B = 2
 C = 3
Input 2:

 A = 4
 B = 2
 C = 3


Example Output
Output 1:

 2
Output 2:

 6


Example Explanation
Explanation 1:

 1st magical number is 2.
Explanation 2:

 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.*/
public class Ath_Magical_Number {
	public static void main(String[] args) {
		int A = 4;
		int B = 2;
		int C = 3;
		
		long MOD = 1_000_000_007;
        long lcm = 1L*B/GCD(B,C)*C;
		
		long low = 1L;
		long heigh = (long)(1e18);
		long result = 0;
		
		while(low<heigh) {
			long mid = low + (heigh - low) / 2;
		//	int val = calculate(mid, B, C, lcm);
            long temp = mid/B+mid/C-mid/lcm;
			if(temp < A) {
				low = mid+1;
			}
			else {
				heigh = mid;
			}
		}
	      System.out.println( (int)(low%MOD));
		
		
		
		
	}
	static int calculate(long mid, int B, int C, int lcm) {
		
		return (int) (((mid/B)+(mid/C))- (mid/lcm));
	}
	static int GCD (int a , int b) {
		if(b == 0)
			return a;
		return GCD(b, a%b);
	}

}
