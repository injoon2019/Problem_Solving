//Baekjoon - 2004
//https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
import java.io.*;
import java.util.*;
//DFS, BFS를 인접행렬로 구현하면 시간복잡도가 O(V2)이지만, 
//인접리스트로 구현하면 O(V+E)가 됩니다. (V는 정점 개수, E는 간선 개수)
public class BaekJoon2004 {
	
	static ArrayList<Integer>[] list;
	static int n;
	static boolean[] check;
	
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		
		list = new ArrayList[n+1];
		
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1; i<n+1; i++) {
			Collections.sort(list[i]);
		}
		check = new boolean[n+1];
		dfs(start);
		System.out.println();
		
		check = new boolean[n+1];
		bfs(start);
		System.out.println();
		
		sc.close();
	}	
	
	private static void dfs(int x) {
		if(check[x]) {
			return;
		}
		check[x]= true;
		System.out.print(x+" ");
		for(int y : list[x]) {
			if(!check[y])
				dfs(y);
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x+" ");
			for(int y : list[x]) {
				if(!check[y]) {
					check[y]=true;
					queue.add(y);
				}
			}
		}
	}
}