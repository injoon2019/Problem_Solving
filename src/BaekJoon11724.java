//Baekjoon - 11724
import java.io.*;
import java.util.*;
//DFS, BFS�� ������ķ� �����ϸ� �ð����⵵�� O(V2)������, 
//��������Ʈ�� �����ϸ� O(V+E)�� �˴ϴ�. (V�� ���� ����, E�� ���� ����)
public class BaekJoon11724 {
	
	static ArrayList<Integer>[] list;
	static boolean[] check;
	static boolean[] check2;
	static int count = 0;
	
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		list = new ArrayList[N+1];
		for(int i=1;  i<=N; i++) {
			list[i] =  new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		check = new boolean[N+1];
		check2 = new boolean[N+1];
		int count = 0;
		for(int i=1;  i<=N; i++) {
			if(!check[i]) {
				bfs(i);
				count++;
			}
		}
		System.out.println(count);
		sc.close();
	}	
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start]= true;
		
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