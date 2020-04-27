//Baekjoon - 9019 DSLR
//https://dundung.tistory.com/66
import java.io.*;
import java.util.*;
public class BaekJoon9019 {
	
	static int A,B;
	static int n;
	static boolean[] visited;
	static String[] command;
	public static void main(String[] args)throws Exception{
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for(int t=0; t<T; t++) {
			A = scan.nextInt();
			B = scan.nextInt();
			bfs();
		}
	}
	
	public static void bfs() {
		visited = new boolean[10000];
		command = new String[10000];
		Queue<Integer> q = new LinkedList<>();
		q.add(A);
		visited[A]=true;
		Arrays.fill(command, "");
		
		while(!q.isEmpty() && !visited[B]) {
			int now = q.poll();
			int D = (2*now)%10000;
			int S = (now==0)? 9999: now-1;
			int L = (now%1000)*10+now/1000;
			int R = (now%10)*1000+now/10;
			
			if(!visited[D]) {
				q.add(D);
				visited[D]=true;
				command[D]=command[now]+"D";
			}
			if(!visited[S]) {
				q.add(S);
				visited[S]=true;
				command[S]=command[now]+"S";
			}
			if(!visited[L]) {
				q.add(L);
				visited[L]=true;
				command[L]=command[now]+"L";
			}
			if(!visited[R]) {
				q.add(R);
				visited[R]=true;
				command[R]=command[now]+"R";
			}
		}
		System.out.println(command[B]);
	}	
}

