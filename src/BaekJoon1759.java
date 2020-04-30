//Baekjoon - 1759 암호 만들기 
import java.io.*;
import java.util.*;

public class BaekJoon1759 {

	static int N, M;
	static char[] arr;
	static int[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");

		N = Integer.parseInt(strToken[0]);
		M = Integer.parseInt(strToken[1]);
		arr = new char[M];
		result = new int[M];
		
		strToken = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			arr[i] = strToken[i].charAt(0);
		}
		Arrays.parallelSort(arr);
		DFS(0,0,0,0);
	}
	
	//시작점, 선택된 문자 갯수, 자음 갯수, 모음 갯수
	public static void DFS(int start, int depth, int ja, int mo) {
		
		for(int i=start; i<M; i++) {
			result[i] = 1;	//선택된 문자 확인용
		}
	}
}
