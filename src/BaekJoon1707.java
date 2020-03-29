//Baekjoon - 1707
import java.io.*;
import java.util.*;

public class BaekJoon1707 {
		static ArrayList<Integer>[] list;
		static boolean[] check;
		static boolean[] color;
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int V, E;
		int x, y;
		for(int i=0; i<K; i++) {
			V = sc.nextInt();
			E = sc.nextInt();

			list = new ArrayList[V+1];
			check = new boolean[V+1];
			color = new boolean[V+1];
			for(int j=1;  j<V+1; j++) {
				list[j] = new ArrayList<Integer>();
			}
			int start=0;
			for(int j=0; j<E; j++) {
				x = sc.nextInt();
				y= sc.nextInt();
				list[x].add(y);
				list[y].add(x);
				start = x;
			}
			
			for(int j=1; j<V+1; j++) {
				Collections.sort(list[j]);
			}
			color[start]=true; 
			dfs(start);
			ArrayList<Integer> unVisited =  new ArrayList<Integer>();
			for(int t=1; t<=V; t++) {
				if(!check[t]) {
					unVisited.add(t);
				}
			}
			
			for(int p : unVisited) {
				dfs(p);
			}
			
			boolean bipartite = true;
			for(int t=1; t<=V; t++) {
				for(int j: list[t]) {
					if(color[j]==color[t]) {
						bipartite = false;
					}
				}
			}
			if(bipartite)
				System.out.println("YES");
			else
				System.out.println("NO");
			
			
		}
		sc.close();
	}	
	
	private static void dfs(int x) {
		if(check[x])
			return;
		
		check[x]=true;
		for(int y : list[x]) {
			if(!check[y]) {
				color[y] = !color[x];
				dfs(y);
			}
		}
	}
	
//	private static boolean isBipartite(int V) {
//		for(int i=1; i<=V; i++) {
//			for(int y : list[i]) {
//				if(color[y]==color[i]) {
//					return false;
//				}
//			}
//		}
//		return true;
//	}

}