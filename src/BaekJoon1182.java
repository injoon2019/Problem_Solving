//Baekjoon - 1182 부분수열의 합 
import java.io.*;
import java.util.*;

public class BaekJoon1182 {
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
		
		dfs(0,0);
		System.out.println(cnt);
	}	
	
	public static void dfs(int i, int sum) {
		if(i==N)
			return;
		
		if(sum+arr[i]==S)
			cnt++;
		
		//현재 가리키고 있는 수를 더하는 경우와
		//그렇지 않고 다음 index로 건너 뛰는 경우 
		dfs(i+1, sum);
		dfs(i+1, sum+arr[i]);
	}
}