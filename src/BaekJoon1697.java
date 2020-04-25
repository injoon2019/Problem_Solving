//Baekjoon - 1697 숨바꼭질

import java.io.*;
import java.util.*;
public class BaekJoon1697 {
	
	static int visit[] = new int[100001];
	static int n;
	static int m;
	
	public static void main(String[] args)throws Exception{
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();	//수빈이
		m = scan.nextInt();	//동생
		bfs();
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(n);
		visit[n]=1;
		
		while(!q.isEmpty()) {
			n = q.poll();
			
			if(n==m)
				break;
			
			if(n+1 <= 100000 && visit[n+1] ==0) {
				q.add(n+1);
				visit[n+1] = visit[n]+1;
			}
			
			if(n-1>=0 && visit[n-1]==0) {
				q.add(n-1);
				visit[n-1] = visit[n]+1;
			}
			
			if(n*2 <= 100000 && visit[n*2]==0) {
				q.add(n*2);
				visit[n*2] = visit[n]+1;
			}
		}
		//0이 아닌 1에서 시작했으므로 
		System.out.println(visit[m]-1);
	}
	
}

