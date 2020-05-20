//Baekjoon - 10989_2
//Counting Sort

import java.io.*;
import java.util.Arrays;

public class BaekJoon10989_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[20000+1];
		for(int i=0; i<N; i++) {
			int k = Integer.parseInt(br.readLine());
			count[10000+k]++;
		}
		for(int i=0; i<20001; i++) {
			int tmp = count[i];
			if(tmp!=0) {
				for(int t=0; t<tmp; t++) {
					sb.append(i-10000+"\n");
				}
			}
		}
		bw.append(sb);
		bw.flush();
		
	}
}