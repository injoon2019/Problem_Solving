//Baekjoon - 11652

import java.io.*;
import java.util.Arrays;

public class BaekJoon11652 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		for(int i=0; i<N; i++) {
			arr[i]= Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		int cur=0; int max = 0;
		max=0;
		long ans = Long.MIN_VALUE;
		long tmp = Long.MIN_VALUE;
		for(int i=0; i<N; i++) {
			if(arr[i]== tmp) {
				cur++;
			}else if(arr[i]>tmp) {
				cur=0;
				cur++;
				tmp =arr[i];
			}
			
			if(max<cur) {
				max=cur;
				ans= arr[i];
			}
		}
		
		System.out.println(ans);
	}


}