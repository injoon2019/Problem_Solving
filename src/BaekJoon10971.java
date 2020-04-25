//Baekjoon - 10971 외판원 순회 2
//https://whereisusb.tistory.com/136
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
public class BaekJoon10971 {

	static int n;
	static int[][] arr;
	
	static int min = Integer.MAX_VALUE;
	static int start = 0;
	static boolean[] visited;
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited= new boolean[n];
		for(int i=0; i<n; i++) {
			start = i;
			solve(i,i,0,0);
		}
		System.out.println(min);
	}
	
	private static void solve(int x, int y, int cnt, int sum) {
		//cnt와 n이 같고, y가 start이면 처음 시작한 곳으로 돌아오는 것
		if(cnt==n && start ==y) {
			min = Math.min(min,  sum);
			return;
		}
		//도착한 y에서 이동
		for(int i=0; i<n; i++) {
			if(visited[i])
				continue;
			//y -> i로 갈 수 없는 경우 0 값을 가지고 있다
			//따라서 y==i인 경우만 체크해주면 틀린 값을 얻게된다
			if(arr[y][i]==0) continue;
			if(sum+ arr[y][i]> min) continue;
			visited[i] = true;
			solve(y, i, cnt+1, sum+arr[y][i]);
			visited[i] = false;
		}
	}
}

