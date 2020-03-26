//Baekjoon - 11653

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class BaekJoon11653 {
	static boolean[] arr;

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 2; i*i<=n; i++) {
			while(n%i == 0) {
				sb.append(i).append('\n');
				n /= i;
			}
		}
		if(n != 1) {
			sb.append(n);
		}
		
		System.out.println(sb);

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();
//		int size= 10000000;
//		arr = new boolean[size+1];
//		arr[0]=true;
//		arr[1]=true;
//		
//		for(int i=2; i<=size; i++) {
//			if(arr[i]==true)
//				continue;
//			
//			for(int j=i+i; j<=size; j+=i) {
//				arr[j]= true;
//			}
//		}
//		int n= Integer.parseInt(br.readLine());
//		for(int i=2; i<=n; i++) {
//				if(arr[i]==false && n%i==0) {
//					sb.append(i).append("\n");
//					n/=i;
//					if(n==1)
//						break;
//					i--;
//				}
//		}
//				
//		bw.append(sb);
//		bw.flush();
	}	
}