//Baekjoon - 2251 물통
import java.io.*;
import java.util.*;
public class BaekJoon2251 {
	
	static boolean[][] visited = new boolean[201][201];
	static boolean[] ans = new boolean[201];
	static Scanner scan = new Scanner(System.in);
	static int a,b,c;
	
	public static void main(String[] args)throws Exception{
		solve();
	}
	
	static void solve() {
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		
		dfs(0,0,c);
		
		for(int i=0; i<201; i++) {
			if(ans[i]) {
				System.out.print(i+" ");
			}
		}
	}
	
	public static void dfs(int ca, int cb, int cc) {
		if(visited[ca][cb]) {
			return;
		}
		
		if(ca==0) {
			ans[cc]=true;
		}
		
		/*물통의 갯수가 3개로 정해져 있기에 가능한 모든 경우는 다음과 같다
		 * A->B	//A의 물을 B로 옮기는 경우
		 * A->C
		 * B->A
		 * C->A
		 * C->B
		 */
		visited[ca][cb]=true;
		
		//a->b
		if(ca+cb > b) {
			dfs((ca+cb)-b, b, cc);
		}else {
			dfs(0, ca+cb, cc);
		}
		//b->a
		if(cb+ca > a) {
			dfs(a, (cb+ca)-a, cc);
		}else {
			dfs(cb+ca, 0, cc);
		}
		//c-> a
		if(cc+ca >a) {
			dfs(a, cb, (cc+ca)-a);
		}else {
			dfs(cc+ca, cb, 0);
		}
		//c-> b
		if(cc+cb > b) {
			dfs(ca, b, (cc+cb)-b);
		}else {
			dfs(ca, cc+cb, 0);
		}
		//b->c, a->c
		//a+b = c이기 때문에 c가 넘칠일이 없다
		dfs(ca, 0, cb+cc);
		dfs(0, cb, ca+cc);
	}
}

