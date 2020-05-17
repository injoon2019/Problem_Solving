//Baekjoon - 11053_3
//https://www.youtube.com/watch?v=fV-TF4OvZpk

import java.io.*;
import java.util.*;

public class BaekJoon11053_3 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		String[] strToken = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(strToken[i]);
			//최소 길이가 1이다. 그 자리에서 시작해서 끝나는 경우.
			dp[i] = 1;
		}
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j] && dp[i]<=dp[j]) {
					dp[i] = dp[j]+1;
				}
			}
		}
		int max = dp[0];
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}	
}