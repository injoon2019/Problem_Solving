//Baekjoon - 11055

import java.io.*;
public class BaekJoon11055 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		String[] strToken = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(strToken[i]);
		}
		
		dp[0]= arr[0];
		
		//10
		//1 100 55 50 60 3 5 6 7 8
		//의 경우에 질문자님 코드에선 1 + 55 + 50 + 60 = 166이 출력되지만
		//실제 가장 큰 증가 부분 수열은 1 + 55 + 60 으로 116이 정답 입니다.
		for(int i=1; i<N; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				if(arr[j]  < arr[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			
			dp[i]=arr[i]+max;
		}
		int max = dp[0];
		
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}	
}