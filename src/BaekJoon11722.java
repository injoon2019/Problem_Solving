//Baekjoon - 11722

import java.io.*;
public class BaekJoon11722 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strToken = br.readLine().split(" ");
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i=0;  i<N; i++) {
			arr[i]= Integer.parseInt(strToken[i]);
		}
		int max=0;
		for(int i=0; i<N; i++) {
			 max = 0;
			for(int j=0; j<N; j++) {
				if(arr[i]< arr[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max+1;
		}
		
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}	
}