//Baekjoon - 2579

import java.io.*;
public class BaekJoon2579 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[][] dp = new int[2][N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		int tmp;
		//�� ������ ����� �� ��ƾ��Ѵٰ� �ϴ� ó������ ����� ó���� ��� ��������
		for(int i=0; i<N/2; i++) {
			tmp = arr[i];
			arr[i] = arr[N-i-1];
			arr[N-i-1] = tmp;
		}
		
		dp[0][0] =arr[0];
		dp[1][0] = arr[0];
		if(N>=2)
			dp[1][1]= dp[0][0]+arr[1];
		//dp[1][i] = �� ���� ���� ���� ����̹Ƿ� dp[0][i-1] + arr[i]
		//dp[0][i] = �� ���� ���� �ȹ�����Ƿ� �ΰ��� �ɼ��� �����. ���� Math.max(dp[0][i-2], dp[1][i-2]) + arr[i]
		for(int i=2; i<N; i++) {
			dp[0][i] = Math.max(dp[0][i-2], dp[1][i-2]) +arr[i];
			dp[1][i] = dp[0][i-1] +arr[i];
		}
		int max = dp[0][0];
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[0][i]);
			max = Math.max(max,  dp[1][i]);
		}

		System.out.println(max);
	}	
}