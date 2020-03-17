//Baekjoon - 11004

import java.io.*;
import java.util.Arrays;

public class BaekJoon11004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strToken = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(strToken[0]);
		int K = Integer.parseInt(strToken[1]);
		int[] arr = new int[N];
		strToken = br.readLine().split(" ");
		for(int i=0;  i<N; i++) {
			arr[i]= Integer.parseInt(strToken[i]);
		}
		Arrays.sort(arr);
		sb.append(arr[K-1]);
		bw.append(sb);
		bw.flush();
	}


}