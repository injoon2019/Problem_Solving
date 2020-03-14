//Baekjoon - 2011

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
///https://jaimemin.tistory.com/459 <- 풀이법 깔끔! 나중에 꼭 다시 풀어봐라
public class BaekJoon2011 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		long[] dp = new long[N.length()+1];
		dp[0]=1;
		dp[1]=1;
		
		if(N.charAt(0)=='0') {
			System.out.println(0);
			return;
		}
		
		for(int i=1; i<N.length(); i++) {
			char pri = N.charAt(i-1);//이전 숫자
			if(N.charAt(i)>='1'&& N.charAt(i)<='9')//혼자 올 수 있음
			{
				dp[i+1] +=dp[i];
				dp[i+1] %=  1000000;
			}
			if(!(pri=='0'||pri>'2'||(pri=='2'&&N.charAt(i)>'6')))
			{	//두 글자가 될 수 있다면
				dp[i+1] +=dp[i-1];
				dp[i+1]%= 1000000;
				
			}
		}
		
		System.out.println(dp[N.length()]%1000000);
		
	}
}