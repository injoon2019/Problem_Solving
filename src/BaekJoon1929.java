//Baekjoon - 1929

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
public class BaekJoon1929 {
	static boolean[] arr;
	
	
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");
		int M =  Integer.parseInt(strToken[0]);
		int N = Integer.parseInt(strToken[1]);
		arr = new boolean[N+1];
		
		for(int i=2; i<=N; i++) {
			if(arr[i]==true)
				continue;
			
			for(int j=i+i; j<=N; j+=i) {
				arr[j]= true;
			}
		}
		int count=0;
		for(int i=M; i<=N; i++) {
			if(arr[i]==false && i!=1) {
				System.out.println(i);
			}
		}
	}	
}