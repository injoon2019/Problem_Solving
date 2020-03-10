//Baekjoon - 2133
import java.io.*;
public class BaekJoon2133 {
	///https://jaimemin.tistory.com/330
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[31];
		dp[0]=1;
		dp[1]=0;
		dp[2]=3;
		int x=0;
		int y=0;
		for(int i=4; i<31; i++) {
			if(i%2==1) {
				dp[i]=0;
				continue;
			}
			//dp[i-2] ���� 3*2 ¥���� ���� �Ͱ� ���������ϱ�
			dp[i] = dp[i-2]* dp[2];
			
			for(int j=4; j<=i; j+=2) {
				dp[i] += dp[i-j]*2; 	//�� ���� ���̽��鸶�� 2���� Ư���� ��찡 �ִ�
			}
		}
		
		System.out.println(dp[N]);
	}	
}