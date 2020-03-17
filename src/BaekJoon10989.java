//Baekjoon - 10825

import java.io.*;
import java.util.Arrays;

public class BaekJoon10989 {

	public static void main(String[] args)throws Exception{

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n= Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(br.readLine());	
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i : arr) {
			sb.append(i);
			sb.append('\n');
		}
		bw.append(sb);
		bw.flush();
	}	
}