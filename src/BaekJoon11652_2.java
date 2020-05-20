//Baekjoon - 11652_2

import java.io.*;
import java.util.Arrays;

public class BaekJoon11652_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.parallelSort(arr);
		int max = Integer.MIN_VALUE;
		int ansIndex = 0;
		long prev = Integer.MIN_VALUE;
		int curCount = 1;
		for(int i=0; i<N; i++) {
			if(arr[i]==prev) {
				curCount++;
			}else {
				prev = arr[i];
				if(curCount>max) {
					max = curCount;
					ansIndex = i;
				}
				curCount = 1;
			}
		}
		System.out.println(arr[ansIndex]);
	}


}