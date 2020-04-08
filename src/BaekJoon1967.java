//Baekjoon - 1967
//¡ı∏Ì: https://blog.myungwoo.kr/112
import java.io.*;
import java.util.*;

public class BaekJoon1967 {
	
	public static void main(String[] args) throws Exception {		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] dist = new int[n+1];
		List<Edge>[] list = (List<Edge>[])new ArrayList[n+1];
		
		for(int i=0; i<=n; i++) {
			list[i]= new ArrayList<>();
		}
		
		for(int i=0; i<n-1; i++) {
			int parent = scan.nextInt();
			int child = scan.nextInt();
			int weight = scan.nextInt();
			
			list[parent].add(new Edge(child, weight));
			list[child].add(new Edge(parent, weight));
		}
		
		dist = bfs(list, 1, n);
		int start = 1;
		for(int i=2; i<=n; i++) {
			if(dist[start]<dist[i])
				start = i ;
		}
		
		dist = bfs(list, start, n);
		Arrays.parallelSort(dist);
		System.out.println(dist[n]);
	}
	
	static int[] bfs(List<Edge>[] list, int start, int n) {
		boolean[] b = new boolean[n+1];
		int[] dist = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		b[start]=true;
		
		while(!q.isEmpty()) {
			int v =q.poll();
			for(Edge e : list[v]) {
				int y = e.y;
				int cost = e.cost;
				if(!b[y]) {
					b[y]=true;
					q.add(y);
					dist[y] = dist[v]+cost;
				}
			}
		}
		
		return dist;
	}

}

class Edge{
	int y, cost;
	Edge(int y, int cost){
		this.y = y;
		this.cost =cost;
	}
}



