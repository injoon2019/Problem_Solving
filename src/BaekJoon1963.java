//Baekjoon - 1963 소수 경로 

import java.io.*;
import java.util.*;
public class BaekJoon1963 {
	static int x, y;
	//false여야 소수다
	static boolean[] pNum= new boolean[10000]; 
	public static void main(String[] args)throws Exception{
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		Erathos();
		for(int t=0; t<T; t++) {
			x = scan.nextInt();
			y = scan.nextInt();
			bfs();
		}
		
	}
	
	public static int change(int num, int index, int v) {
		StringBuilder sb = new StringBuilder(String.valueOf(num));
		sb.setCharAt(index, (char)(v+'0'));	//int를 char로 바꾸기 위해
		return Integer.parseInt(sb.toString());
	}
	
	//모든 간선의 비용이 1인 그래프에서 최단거리를 구하는 문제는 BFS로 풀어요.
	//DFS로 풀려면 지수시간 복잡도가 나와요. DFS(u)를 했을 때 v에 처음 도달한 값이
	//최소 거리라는게 보장이 안되니깐 모든경로에 대해서 가봐야하거든요.
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] d = new int[10000];
		boolean[] b = new boolean[10000];
		
		q.add(x);
		b[x] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int i=0; i<4; i++) {
				for(int j=0; j<=9; j++) {
					if(i==0 && j==0) {	//0번째 자리를 0으로 바꾸는 것은 안된다
						continue;
					}
					int k = change(v,i,j);
					if(pNum[k]==false && !b[k]) {
						d[k] = d[v]+1;
						b[k] = true;
						q.add(k);
					}
				}
			}
			
		}
		System.out.println(d[y]);
	}
	
	public static void Erathos() {
		for(int i=2; i*i<=9999; i++) {
			for(int j=i+i; j<=9999; j+=i) {
				pNum[j]= true;
			}
		}
	}
	
}

