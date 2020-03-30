//Baekjoon - 10451
import java.io.*;
import java.util.*;

public class BaekJoon10451 {
	static ArrayList<Integer>[] list;
	static boolean[] check;
	
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N+1];
			check = new boolean[N+1];
			list = new ArrayList[N+1];
			
			for(int i=1; i<=N; i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			for(int i=1; i<=N; i++) {
				arr[i]=sc.nextInt();
			}
			
			for(int i=1; i<=N; i++) {
				list[i].add(arr[i]);
			}
			
			for(int i=1; i<=N; i++) {
				Collections.sort(list[i]);
			}
			
			int count=0;
			for(int i=1; i<=N; i++) {
				if(check[arr[i]] ==false) {
					count++;
					bfs(arr[i]);
				}
			}
			System.out.println(count);			
		}

		sc.close();
	}	
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start]=true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			for(int y : list[x]) {
				if(!check[y]) {
					check[y]=true;
					queue.add(y);
				}
			}
		}
	}
}