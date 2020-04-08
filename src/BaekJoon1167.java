//Baekjoon - 1167 Ʈ���� ����
//����: https://blog.myungwoo.kr/112
import java.io.*;
import java.util.*;

public class BaekJoon1167 {
	static int[] bfs(List<Edge>[] list, int start, int n) {
		boolean[] b = new boolean[n+1];
		int[] dist = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		b[start] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			for(Edge e : list[v]) {
				int y = e.y;
				int cost = e.cost;
				if(!b[y]) {
					b[y] = true;
					q.add(y);
					dist[y] = dist[v]+cost;
				}
			}
		}
		
		return dist;
	}

	
	public static void main(String[] args) throws Exception {		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<Edge>[] list =  (List<Edge>[])new ArrayList[n+1];
		int[] dist = new int[n+1];
		
		for(int i=0;i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n; i++) {
			int x= scan.nextInt();
			while(true) {
				int y = scan.nextInt();
				if(y == -1)
					break;
				int cost = scan.nextInt();
				list[x].add(new Edge(y,cost));
			}
		}
		
		dist = bfs(list,1,n);	//���� �� ������ ���� ã��
		int start= 1;
		for(int i=2; i<=n; i++) {
			if(dist[start]<dist[i])
				start = i;
		}
		
		dist = bfs(list, start, n);	//���� �� ������ ������ ��Ʈ�� dist�迭 �ʱ�ȭ
		Arrays.parallelSort(dist);
		System.out.println(dist[n]);//���� �� �ִ밪 ��� 
	}

}

class Edge{
	int y; 
	int cost;
	
	public Edge(int y, int cost) {
		this.y =y;
		this.cost = cost;
	}
}



