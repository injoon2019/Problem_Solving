//Baekjoon - 1260
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BaekJoon1260_2 {
	static int N, M, V;
	static ArrayList<Integer>[] list;
	static boolean[] check;
	
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		list = new ArrayList[N+1];
		check = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		
		DFS(V);
		System.out.println();
		check = new boolean[N+1];
		BFS();
		System.out.println();
	}	
	
	public static void DFS(int start) {
		if(check[start]==true) {
			return;
		}
		check[start]=true;
		System.out.print(start+" ");
		for(int i : list[start]) {
			if (check[i]==false) {
				DFS(i);
			}
		}
		
	}
	
	public static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		check[V]=true;
		while(!queue.isEmpty()) {
			int x = queue.remove();
			System.out.print(x+" ");
			for(int i: list[x]) {
				if(check[i]==false) {
					queue.add(i);
					check[i]=true;
				}
			}
		}
	}
}