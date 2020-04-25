//Baekjoon - 1963 �Ҽ� ��� 

import java.io.*;
import java.util.*;
public class BaekJoon1963 {
	static int x, y;
	//false���� �Ҽ���
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
		sb.setCharAt(index, (char)(v+'0'));	//int�� char�� �ٲٱ� ����
		return Integer.parseInt(sb.toString());
	}
	
	//��� ������ ����� 1�� �׷������� �ִܰŸ��� ���ϴ� ������ BFS�� Ǯ���.
	//DFS�� Ǯ���� �����ð� ���⵵�� ���Ϳ�. DFS(u)�� ���� �� v�� ó�� ������ ����
	//�ּ� �Ÿ���°� ������ �ȵǴϱ� ����ο� ���ؼ� �������ϰŵ��.
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
					if(i==0 && j==0) {	//0��° �ڸ��� 0���� �ٲٴ� ���� �ȵȴ�
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

