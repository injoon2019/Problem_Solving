//Baekjoon - 9466
import java.io.*;
import java.util.*;

public class BaekJoon9466_2 {

	static int[] a;
	static int[] c;
	static int[] s;
	static int ans = 0;
	
	public static int DFS(int[] a, int[] c, int[] s, int v, int step) {
		int cnt = 1;
		
		while(true) {
			if (c[v]!=0) {
				if(s[v]!=step) {
					//이미 방문했고, 정점 시작점이 다를 경우 사이클 x
					return 0;
				}
				return cnt - c[v];
			}
			s[v] = step;
			c[v] = cnt;
			v= a[v];
			cnt++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0) {
			int n = sc.nextInt();
			a = new int[n+1];
			c = new int[n+1];
			s = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				a[i] = sc.nextInt();
			}
			
			for(int i=1; i<=n; i++) {
				if(c[i]==0) {
					ans +=DFS(a,c,s,i,i);
				}
			}
		}
	}
}
