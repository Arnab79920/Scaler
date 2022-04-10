package Searching_II;

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
