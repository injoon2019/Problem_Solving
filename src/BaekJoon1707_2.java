//Baekjoon - 1707_2
import java.io.*;
import java.util.*;

public class BaekJoon1707_2 {
	static int K, V, E;
	
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		for (int tc=0; tc<K; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			LinkedList<Integer>[] graph = new LinkedList[V];
			for(int i=0; i<V; i++) {
				graph[i] = new LinkedList<>();
			}
			for(int i=0; i<E; i++) {
				int s = sc.nextInt() -1;
				int e = sc.nextInt() -1;
				graph[s].add(e);
				graph[e].add(s);
 			}
			
			boolean flag = true;
			int[] visit = new int[V];
			Queue<Integer> q = new LinkedList<>();
			
			for(int i=0; i<V; i++) {
				if(visit[i] == 0) {
					q.offer(i);
					visit[i] = 1;
					
					while( !q.isEmpty() && flag) {
						int cur = q.poll();
						for(Integer next: graph[cur]) {
							if(visit[next] ==0) {
								q.offer(next);
								visit[next] = visit[cur]*-1;
							}else if (visit[next] ==visit[cur]) {
								flag = false;
								break;
							}
						}
					}
				}
			}
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	
	}
}