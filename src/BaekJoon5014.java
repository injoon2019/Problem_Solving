//Baekjoon - 5014 스타트링크
import java.io.*;
import java.util.*;
public class BaekJoon5014 {
	
	static int F, S, G, U, D;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");
		
		F = Integer.parseInt(strToken[0]);	//건물 총 층수
		S = Integer.parseInt(strToken[1]);	//현재
		G = Integer.parseInt(strToken[2]);	//목표
		U = Integer.parseInt(strToken[3]);
		D = Integer.parseInt(strToken[4]);
		arr= new int[F+1];
		bfs();
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		arr[S] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == G) {
				//System.out.println("check");
				System.out.println(arr[cur]-1);
				return;
			}
			int nd = cur-D;
			int nu = cur+U;
			
			if(nd >=1 && nd <=F) {
				if(arr[nd]==0) {
					arr[nd]= arr[cur]+1;
					q.add(nd);
				}
			}
			if(nu>=1 && nu<=F) {	
				if(arr[nu]==0) {
					//System.out.println(nu);
					arr[nu]= arr[cur]+1;
					q.add(nu);
				}
			}	
		}
		System.out.println("use the stairs");
	}

}

