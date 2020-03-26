//Baekjoon - 6588

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
public class BaekJoon6588 {
	static boolean[] arr;
	
	
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int size= 1000000;
		arr = new boolean[size+1];
		arr[0]=true;
		arr[1]=true;
		arr[2]=true;
		
		for(int i=2; i<=size; i++) {
			if(arr[i]==true)
				continue;
			
			for(int j=i+i; j<=size; j+=i) {
				arr[j]= true;
			}
		}
		int n;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			for(int i=n-2; i>=3; i--) {
				if(arr[i]==false&& arr[n-i]==false ) {
					sb.append(n).append(" = ").append(n-i).append(" + ").append(i).append("\n");
					break;
				}
			}
		}
		bw.append(sb);
		bw.flush();
	}	
}