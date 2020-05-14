//Baekjoon - 9251 (LCS-Longest Common Subsequence)
import java.io.*;
import java.util.*;

public class BaekJoon9251 {
	static String a, b;
	static int dp[][];
	
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		a = sc.nextLine();
		b= sc.nextLine();
		
		//무엇을 기준으로 무엇과 비교할지를 정한 후 순서대로 해야한다
		dp = new int[b.length()+1][a.length()+1];	//각 문자열의 길이만큼 선언
		
		
		for(int i=1; i<=b.length(); i++) {	//b를 기준으로
			for(int j=1; j<=a.length(); j++) {	//a와 비교
				if(b.charAt(i-1) != a.charAt(j-1)) { //다를 경우
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);	//점화식
				}else {
					dp[i][j] =dp[i-1][j-1]+1;	//점화식
				}
			}
		}
		
		System.out.println(dp[b.length()][a.length()]);
	}	
	
}