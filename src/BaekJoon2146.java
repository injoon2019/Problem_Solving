//Baekjoon - 2146
import java.io.*;
import java.util.*;

public class BaekJoon2146 {

	static int N;
	static int[][] reset;
	static int[][] arr;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static int count = 1;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		reset = new int[N][N];
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				reset[i][j] = Integer.parseInt(str[j]);
			}
		}
		//----------------입력------------------\\
		
		//다리를 건너기 전에 해야할 일
		//섬마다 번호를 붙여줘야한다. DFS를 이용해서 이 일을 할 수 있다.
		//1번째 방문하는 섬은 2번으로, 2번째는 3번으로...
		for(int i=0; i<N; i++) {
			for(int j=0;  j<N; j++) {
				if(reset[i][j]==1) {
					count++;
					reset[i][j]=count;
					Labeling_DFS(i,j);
				}
			}
		}
		Reset();	//arr함수를 reset 함수로 초기화 시켜준다 (복사)
		
		//가장 가까운 다리길이를 찾는 과정
		//섬에서 시작하여 다른 섬에 가장 빨리 도착할 때 값을 저장하고 돌아온다
		//섬의 모든 지점에서 확인한다. 상하좌우에 섬이 있을 수 있고 최단거리가 될 수 있으므로
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] !=0) {
					ShortestPath_BFS(i,j);
					Reset();
				}
			}
		}
		System.out.println(min);
	}
	
	public static void Labeling_DFS(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x+ dx[i];
			int ny = y+ dy[i];
			//좌표 넘어가면 패스
			if( nx<0 || ny <0 || nx>=N || ny >=N) {
				continue;
			}
			//다음 갈 위치가 같은 섬이면 패스
			if(reset[nx][ny] ==count) {
				continue;
			}
			//다음 갈 위치가 바다이면 패스
			if(reset[nx][ny]==0) {
				continue;
			}
			//섬의 번호를 count로 통일한다 (count는 2,3,4 등의 순서로 증가한다)
			reset[nx][ny] = count;
			Labeling_DFS(nx, ny);
		}
	}
	
	public static void ShortestPath_BFS(int x, int y) {
		
		//inX, inY는 출발 섬의 값을 저장하기 위한 좌표이다. 
		int inX = x;	//출발 섬의 x좌표
		int inY = y;	//출발 섬의 y좌표
		Queue<DOT> q = new LinkedList<>();
		q.add(new DOT(x, y, 0));
		
		while(!q.isEmpty()) {
			DOT current = q.poll();
			for(int i=0; i<4; i++) {
				//다음 간척사업할 위치 좌표와 거리 저장 변수
				int nX = current.x + dx[i];
				int nY = current.y + dy[i];
				int nextCount = current.count + 1;
				if(nX <0 || nY <0 || nX>=N ||nY>=N) {
					continue;
				}
				//다음 간척할 자리가 이미 섬이라면 패스
				if(arr[nX][nY]== arr[inX][inY]) {
					continue;
				}
				//다음 간척할 자리가 이미 간척한 자리라면 패스
				if(arr[nX][nY]==-1) {
					continue;
				}
				//다음 간척할 자리가 바다가 아니라면
				//이미 섬과 간척자리는 위에 조건에 걸렸으므로 이 조건일 때는 무조건 다른 섬이다
				if(arr[nX][nY]!=0) {
					//다른 섬에 도착했을때의 최단 거리를 비교하여 저장. 그리고 리턴
					min = Math.min(min, nextCount-1);
					return;
				}
				//간척한 자리는 -1로 놓는다. 그리고 큐에 넣는다.
				arr[nX][nY]= -1;
				q.add(new DOT(nX, nY, nextCount));
			}
		}
	}
	
	//간척 사업으로 인해 -1로 변한 자리를 되돌려 놔야 다른 최단거리를 구할 수 있다
	public static void Reset() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = reset[i][j];
			}
		}
	}
}

class DOT{
	int x;
	int y;
	int count;
	DOT(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count  = count;
	}
}



