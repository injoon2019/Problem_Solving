//Baekjoon - 11725 Ʈ���� �θ� ã�� 
import java.io.*;
import java.util.*;

public class BaekJoon11725 {
	
	static ArrayList<Integer>[] list;
	static int[] parents;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		//��� ��
		//parents[i] = j (i�� �θ��:j)
		parents = new int[N+1];
		visit = new boolean[N+1];
		
		String[] strToken;
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<N-1; i++) {
			strToken = br.readLine().split(" ");
			int a = Integer.parseInt(strToken[0]);
			int b = Integer.parseInt(strToken[1]);
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);
		
		//��� ���
		for(int i=2; i<=N; i++) {
			System.out.println(parents[i]);
		}
	}
	
	private static void dfs(int v) {
		visit[v]= true;
		
		for(int i: list[v]) {
			//visited �Ǿ��ٴ� ���� �̹� �θ� �Ǿ��ٴ� ���̴�. 
			if(!visit[i]) {
				parents[i] = v;
				dfs(i);
			}
		}
	}
}



