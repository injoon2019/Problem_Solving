//Baekjoon - 10989

import java.io.*;
import java.util.Arrays;

public class BaekJoon10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] numCountArr = new int[10001];
		
		for(int i=0; i<N; i++) {
			numCountArr[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i=0; i<numCountArr.length; i++) {
			if(numCountArr[i] == 0) continue;
			while(numCountArr[i]-- > 0) bw.write(i+"\n");
		}
		
		bw.flush();
	}

//	public static void main(String[] args)throws Exception{
//
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int n= Integer.parseInt(br.readLine());
//		int[] arr = new int[n];
//
//		for(int i=0; i<n; i++) {
//			arr[i]= Integer.parseInt(br.readLine());	
//		}
//		Arrays.sort(arr);
//		StringBuilder sb = new StringBuilder();
//		for(int i : arr) {
//			sb.append(i);
//			sb.append('\n');
//		}
//		bw.append(sb);
//		bw.flush();
//	}	
}