package DP6;

public class RECTANGLE_SUM {
	public static void main(String[] args) {
		int[][] A = {{-1, -1}, {-1, -1}};
		int max = 0;
        if(A.length == 1 && A[0].length ==1){
            if(A[0][0]>0)
            System.out.println(A[0][0]);
        }
		for(int j = 0; j<A[0].length; j++) {
			int ar[] = new int[A.length];
			for(int jn = j; jn<A[0].length; jn++) {
				for(int i = 0; i<A.length; i++) {
					if(j == jn)
					ar[i] += A[i][j];
					else
						ar[i] = ar[i]+A[i][jn];
					}
				int current = ar[0];
				for(int i = 1; i<ar.length; i++) {
				current = Math.max(ar[i], current+ar[i]);
				max = Math.max(max, current);
			}
				}
			}
		System.out.println(max);
	}

}
