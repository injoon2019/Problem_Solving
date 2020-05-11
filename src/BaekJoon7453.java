//Baekjoon - 7453 합이 0인 네 정수
import java.io.*;
import java.util.*;

public class BaekJoon7453 {	
	static int[] A,B,C,D;
	
	public static void main(String[] args) throws Exception {		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		A = new int[n];
		B = new int[n];
		C = new int[n];
		D = new int[n];
		
		for(int i=0; i<n; i++) {
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
			C[i] = sc.nextInt();
			D[i] = sc.nextInt();
		}
		
		int[] subsetAB = getSubset(n, A, B);
		int[] subsetCD = getSubset(n, C, D);
		
		Arrays.sort(subsetAB);
		Arrays.sort(subsetCD);
		
		int left = 0;
		int right = n*n -1;
		long cnt = 0;
		
		while(left< n*n && right >= 0) {
			int leftVal = subsetAB[left];
			int rightVal = subsetCD[right];
			int tmp = leftVal + rightVal;
			
			if(tmp<0) {
				while(left < n*n && subsetAB[left]== leftVal) {
					left++;
				}
			}else if (tmp > 0 ) {
				while(right >=0 && subsetCD[right]==rightVal) {
					right--;
				}
			}else {
				long leftCnt = 1;
				long rightCnt = 1;
				
				while(left < n*n && subsetAB[left]==leftVal) {
					left++;
					leftCnt++;
				}
				
				while(right>=0 && subsetCD[right]== rightVal) {
					rightCnt++;
					right--;
				}
				cnt += leftCnt * rightCnt;
			}
		}
		System.out.println(cnt);

	}
	
	private static int[] getSubset(int n, int[] a, int[] b) {
		int[] subset = new int[n*n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				subset[i*n+j] = a[i]+b[j];
			}
		}
		return subset;
	}
}



