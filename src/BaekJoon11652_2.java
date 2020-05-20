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
		long prev = arr[0];
		long maxCount = 0;
		long curCount = 1;
		int maxIndex = 0;
		for(int i=1; i<N; i++) {
			if(i==N-1) {
				//다르면
				if(arr[i]!=prev) {
					if(curCount > maxCount) {
						maxCount = curCount;
						maxIndex = i-1;
					}
				}
				//같으면
				else {
					curCount++;
					if(curCount > maxCount) {
						maxCount = curCount;
						maxIndex = i-1;
					}
				}
			}
			//다른 숫자가 나왔다면
			else if(arr[i]!= prev) {
				//maxCount랑 curCount 비교
				if(curCount > maxCount) {
					maxCount = curCount;
					maxIndex = i-1;
				}
				curCount = 1;
				prev = arr[i];
			}else {
				curCount++;
			}
		}
		System.out.println(arr[maxIndex]);
	}


}