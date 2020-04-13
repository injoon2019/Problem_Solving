//Baekjoon - 2447 별찍기 - 10
import java.io.*;
import java.util.*;

public class BaekJoon2447 {
	
	public static char[][] arr;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j]= ' ';
			}
		}
		
		divideAndConquer(0,0,N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		bw.append(sb);
		bw.flush();
	}
	
	static void divideAndConquer(int r, int c, int len) {
		if(len==1) {
			arr[r][c]='*';
		}else {
			int newlen = len/3;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(i==1 && j==1)	//if(i==newlen-2 && j==newlen-2) <-처음 코딩
						continue;					//발상!!
					else
						divideAndConquer(r+i*newlen, c+j*newlen, newlen);
				}
			}
		}
	}
}