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
				//�ٸ���
				if(arr[i]!=prev) {
					if(curCount > maxCount) {
						maxCount = curCount;
						maxIndex = i-1;
					}
				}
				//������
				else {
					curCount++;
					if(curCount > maxCount) {
						maxCount = curCount;
						maxIndex = i-1;
					}
				}
			}
			//�ٸ� ���ڰ� ���Դٸ�
			else if(arr[i]!= prev) {
				//maxCount�� curCount ��
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