//Baekjoon - 2448 별찍기 - 11
import java.io.*;
import java.util.*;

public class BaekJoon2448 {
	
	public static char[][] arr;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][2*N-1];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<2*N-1; j++) {
					arr[i][j]=' ';
			}
		}
		divideAndConquer(N, N-1, 0);
		
		for(int i=0; i<N; i++) {
			bw.write(arr[i]);
			bw.write('\n');
		}
		bw.flush();
	}
	
	static void divideAndConquer(int n, int x, int y) {
		if(n==3) {//높이가 3이라면 별을 만들어 출력한다
			arr[y][x]='*';
			arr[y+1][x-1]='*';
			arr[y+1][x+1]='*';
			
			arr[y+2][x-2]='*';
			arr[y+2][x-1]='*';
			arr[y+2][x  ]='*';
			arr[y+2][x+1]='*';
			arr[y+2][x+2]='*';
			return;
		}
		divideAndConquer(n/2,x,y);	//위의 삼각형 높이와 맨 위 꼭대기 좌표를 보낸다
		divideAndConquer(n/2, x-(n/2), y+(n/2));//왼쪽 하단 삼각형 높이와 맨 위 꼭대기 좌표를 보낸다
		divideAndConquer(n/2, x+(n/2), y+(n/2));//오른쪽 하단 삼각형 높이와 맨 위 꼭대기 좌표를 보낸다 
	}
}
