//Baekjoon - 1261 알고스팟 (다익스트라)
import java.io.*;
import java.util.*;

public class BaekJoon1261 {
	
	static int R,C;
	static int[][] map;
	static int[][] dist;
	static PriorityQueue<Spot> pq;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static int result = 0;
	
	public static void main(String[] args)throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");
		C = Integer.parseInt(strToken[0]);	//N
		R = Integer.parseInt(strToken[1]);	//M
		
		
		map = new int[R][C];
		dist = new int[R][C];
		
		//input 받으며 dist에는 무한값 저장
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j)-'0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		pq = new PriorityQueue<>();
		bfs();
		System.out.println(result);
	}
	
	public static void bfs() {
		//첫 번째 시작 값
		pq.add(new Spot(0,0,0));
		dist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			
			Spot s = pq.poll();
			
			//끝까지 도착하면 가중치 값 가지고 return
			if(s.y == R-1 && s.x == C-1) {
				result = s.cost;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int ny = s.y + dy[i];
				int nx = s.x + dx[i];
				
				if(ny>=0 && nx>=0 && ny<R && nx<C) {
					
					if(dist[ny][nx] > dist[s.y][s.x]+map[ny][nx]) {
						dist[ny][nx] = dist[s.y][s.x] + map[ny][nx];
						pq.add(new Spot(ny,nx, dist[ny][nx]));
					}
				}
			}
		}
	}
	
}

class Spot implements Comparable<Spot>{
	int y, x , cost;
	public Spot(int y, int x, int cost) {
		this.y = y;
		this.x= x;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Spot o) {
		return this.cost < o.cost ? -1 : 1;
	}
}


