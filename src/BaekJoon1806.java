//Baekjoon - 1806 ºÎºÐÇÕ
//https://wellohorld.tistory.com/28
import java.io.*;
import java.util.*;

public class BaekJoon1806 {
	static int N, M;
	static int[] arr;
	static int MIN = Integer.MAX_VALUE;
	static int ans=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strToken = br.readLine().split(" ");
		N = Integer.parseInt(strToken[0]);
		M = Integer.parseInt(strToken[1]);
	
		arr = new int[N];
		strToken = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(strToken[i]);
		}
		
		int firstPointer = 0, secondPointer = 0;
		int ans = 100001, sum = 0;
		while(true) {
			if(sum >=M) {
				sum -= arr[firstPointer++];
				ans = Math.min(ans, (secondPointer- firstPointer)+1);
			}
			else if(secondPointer == N) break;
			else sum += arr[secondPointer++];
		}
		if(ans==100001) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}
	}
}