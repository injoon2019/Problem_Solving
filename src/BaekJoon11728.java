//Baekjoon - 11728
import java.io.*;
import java.util.*;

public class BaekJoon11728 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strToken = br.readLine().split(" ");
		int N = Integer.parseInt(strToken[0]);
		int M = Integer.parseInt(strToken[1]);
		
		int[] arrA = new int[N];
		int[] arrB = new int[M];
		int[] merge = new int[N+M];

		strToken = br.readLine().split(" ");
		for(int i=0; i<arrA.length; i++) {
			arrA[i] = Integer.parseInt(strToken[i]);
		}
		strToken = br.readLine().split(" ");
		for(int i=0; i<arrB.length; i++) {
			arrB[i] = Integer.parseInt(strToken[i]);
		}
		int indexA = 0;
		int indexB = 0;
		int indexC = 0;
		while(indexA<N && indexB < M) {
			if(arrA[indexA] < arrB[indexB]) {
				merge[indexC++] = arrA[indexA++];
			}else {
				merge[indexC++] = arrB[indexB++];
			}
		}
		//왼쪽에 데이터가 남은 경우
		while(indexA < N) {
			merge[indexC++] = arrA[indexA++];
		}

		//오른쪽에 데이터가 남은 경우
		while(indexB < M) {
			merge[indexC++] = arrB[indexB++];
		}
		
		for(int i=0; i<N+M; i++) {
			bw.write(merge[i]+" ");
		}
		bw.close();
	}
}
