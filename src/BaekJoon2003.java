//Baekjoon - 2003 수들의 합2
import java.io.*;
import java.util.*;

public class BaekJoon2003 {
	static int N, S;
	static int[] arr;
	static int cnt=0;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");
		N = Integer.parseInt(strToken[0]);
		S = Integer.parseInt(strToken[1]);
		arr = new int[N];
		strToken = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(strToken[i]);
		}
		
		for(int i=0; i<N; i++) {
			dfs(i,0);
		}
		System.out.println(cnt);
	}	
	
	public static void dfs(int i, int sum) {
		if(i==N)
			return;
		
		if(arr[i]+sum==S)
			cnt++;
		else {
			sum += arr[i];
			dfs(i+1, sum);
		}	
		
	}
}