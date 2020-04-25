//Baekjoon - 10971 ���ǿ� ��ȸ 2
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
		//cnt�� n�� ����, y�� start�̸� ó�� ������ ������ ���ƿ��� ��
		if(cnt==n && start ==y) {
			min = Math.min(min,  sum);
			return;
		}
		//������ y���� �̵�
		for(int i=0; i<n; i++) {
			if(visited[i])
				continue;
			//y -> i�� �� �� ���� ��� 0 ���� ������ �ִ�
			//���� y==i�� ��츸 üũ���ָ� Ʋ�� ���� ��Եȴ�
			if(arr[y][i]==0) continue;
			if(sum+ arr[y][i]> min) continue;
			visited[i] = true;
			solve(y, i, cnt+1, sum+arr[y][i]);
			visited[i] = false;
		}
	}
}

