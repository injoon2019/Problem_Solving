//Baekjoon - 2178
import java.io.*;
import java.util.*;

public class BaekJoon2178 {

	static int[][] arr;
	static int[][] visited;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = { 0, 1, -1, 0};
	static int Y, X;
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");
		Y = Integer.parseInt(strToken[0]);
		X = Integer.parseInt(strToken[1]);
		arr = new int[Y][X];
		visited = new int[Y][X];
		
		for(int i=0; i<Y; i++) {
			String str =  br.readLine();
			for(int j=0; j<X; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		bfs();
	}
	
	static void bfs() {
		Queue<DOT> queue = new LinkedList<>();
		queue.add(new DOT(0,0));
		visited[0][0]=1;
		int ans = 1;
		while(!queue.isEmpty()) {
			/*bfs에서 깊이의 수를 세주면 됩니다. 약간의 테크닉이라고 할 수도 있는데, bfs를 도는 queue의 사이즈를 체크해서 그 사이즈 만큼 똑같은 bfs를 돌고나면
			카운트를 하나씩 해주는 겁니다. 그리고 다시 똑같이 큐 사이즈 재고 위에서 했던 것을 반복합니다.
			 */
			int size = queue.size();
			for(int s=0;  s<size; s++) {
				DOT dot = queue.poll();
				if(dot.x==X-1 && dot.y==Y-1) {
					System.out.println(ans);
					return;
				}
				
				for(int i=0; i<4; i++) {
					int nx = dot.x+ dx[i];
					int ny = dot.y+ dy[i];
					
					if(nx>=0 && ny>=0 && nx<X && ny<Y) {
						if(arr[ny][nx]==1 && visited[ny][nx]==0) {
							visited[ny][nx]=1;
							queue.add(new DOT(ny,nx));
						}
					}
				}	
			}
			ans++;
		}
	}
	
}

class DOT{
	int x;
	int y;
	
	DOT(int y, int x){
		this.y = y;
		this.x = x;
	}
}
