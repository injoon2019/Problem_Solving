//Baekjoon - 1697 ���ٲ���

import java.io.*;
import java.util.*;
public class BaekJoon1697 {
	
	static int visit[] = new int[100001];
	static int n;
	static int m;
	
	public static void main(String[] args)throws Exception{
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();	//������
		m = scan.nextInt();	//����
		bfs();
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(n);
		visit[n]=1;
		
		while(!q.isEmpty()) {
			n = q.poll();
			
			if(n==m)
				break;
			
			if(n+1 <= 100000 && visit[n+1] ==0) {
				q.add(n+1);
				visit[n+1] = visit[n]+1;
			}
			
			if(n-1>=0 && visit[n-1]==0) {
				q.add(n-1);
				visit[n-1] = visit[n]+1;
			}
			
			if(n*2 <= 100000 && visit[n*2]==0) {
				q.add(n*2);
				visit[n*2] = visit[n]+1;
			}
		}
		//0�� �ƴ� 1���� ���������Ƿ� 
		System.out.println(visit[m]-1);
	}
	
}

