//Baekjoon - 1992 Äõµå Æ®¸® 
import java.io.*;
import java.util.*;

public class BaekJoon1992 {
	
	public static int[][] arr;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;  i<N; i++) {
			str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j)-'0'; 
			}
		}
		
		divideAndConquer(0,0,N);
		bw.append(sb);
		bw.flush();
	}
	
	static boolean isAble(int r, int c, int len) {
		int t = arr[r][c];
		
		for(int i=r; i<r+len; i++) {
			for(int j=c; j<c+len; j++) {
				if(arr[i][j]!= t)
					return false;
			}
		}
		return true;
	}
	
	static void divideAndConquer(int r, int c, int len) {
		if(isAble(r,c,len)) {
			sb.append(arr[r][c]);
		}else {
			int newlen = len/2;
			sb.append("(");
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					divideAndConquer(r+newlen*i, c+newlen*j, newlen);
				}
			}
			sb.append(")");
		}
	}
}
