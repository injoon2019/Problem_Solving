//Baekjoon - 14890 °æ»ç·Î 
import java.io.*;
import java.util.*;
public class BaekJoon14890 {
	
	static int N, L;
	static int[][] arr;
	static int cnt;
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");
		
		strToken = br.readLine().split(" ");
		N = Integer.parseInt(strToken[0]);
		L = Integer.parseInt(strToken[1]);
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			strToken = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(strToken[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			checkRow(i,0);
		}
		for(int j=0; j<N; j++) {
			checkCol(0,j);
		}
	}
	
	static void checkRow(int i, int j) {
		int start  = arr[i][j];
		for(int k=1; k<N; k++) {
			if(arr[i][k]!= arr[i][k-1]) {
				
			}
		}
	}

	static void checkCol(int i, int j) {
		
	}
}

