//Baekjoon - 1699

import java.io.*;
public class BaekJoon1699 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//주의해야 할 점은 n이 12일 경우는, 2의 제곱 3개로 표현이 가능하므로 3의 제곱 + 1의 제곱 3개보다 적은 수의 항으로 표현이 가능하다
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		// dp[n] = n을 제곱수들의 합으로 표현할 때 그 항의 최소 갯수
        // dp[n] = d[n-i^2] + 1 (마지막에 어떤수의 제곱이 올 때 = (i^2)항이 하나니까 1)
		
        for (int i = 1; i <= N; i++){
        	// i가지 있다고 초기화 하고 시작 ( 모든 수는 1^2의 합만으로 나타낼 수 있으니!  )
            dp[i] = i;
            // 제곱의 수가 N보다 클수는 없으니 i (N) 까지 반복하며
            for (int j = 1; j*j <= i; j++){
                if (dp[i] > dp[i-j*j]+1){
                	// d[i]와 d[i - j * j] + 1 비교해서 작으면 최소 개수 변경 
                    dp[i] = dp[i-j*j]+1;
                }
            }
        }

		System.out.println(dp[N]);
	}
	
}