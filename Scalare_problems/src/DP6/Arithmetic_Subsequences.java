package DP6;

import java.util.HashMap;
import java.util.Map;

public class Arithmetic_Subsequences {
	public static void main(String[] args) {
		int [] A = {2, 4, 6, 8, 10};
		Map<Integer, Integer>[] map = new HashMap[A.length];
		for(int i = 0; i<A.length; i++) {
			map[i] = new HashMap<>();
		}
		int ans = 0;
		for(int i = 1; i<A.length; i++) {
			for(int j = 0; j<i; j++) {
				int cd = A[i]- A[j];
				int startwithJ = map[j].getOrDefault(cd, 0);
				int startWithI =  map[i].getOrDefault(cd, 0);
				ans +=startwithJ;
				map[i].put(cd, startWithI+startwithJ+1);
			}
		}
		
		System.out.println(ans);
	
		
		
	

}
	}


