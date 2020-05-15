//Baekjoon - 2156_@
//https://blog.naver.com/PostView.nhn?blogId=occidere&logNo=220791788953
import java.io.*;
import java.util.*;
public class BaekJoon2156_2 {
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		int[] arr = new int[n+3];
		int[] dp = new int[n+3];
		for(int i=3; i<n+3; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=3; i<n+3; i++) {
			//�� ��° ������ �Ͱ�, ù ��° ���� �� ū �� 
			dp[i] = Math.max(dp[i-3]+ arr[i-1]+arr[i], dp[i-2]+arr[i]);
			//�ȸ��ô� ���?
			dp[i] = Math.max(dp[i-1], dp[i]);
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);

	}	
}