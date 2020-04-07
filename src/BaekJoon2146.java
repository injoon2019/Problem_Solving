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
		//----------------�Է�------------------\\
		
		//�ٸ��� �ǳʱ� ���� �ؾ��� ��
		//������ ��ȣ�� �ٿ�����Ѵ�. DFS�� �̿��ؼ� �� ���� �� �� �ִ�.
		//1��° �湮�ϴ� ���� 2������, 2��°�� 3������...
		for(int i=0; i<N; i++) {
			for(int j=0;  j<N; j++) {
				if(reset[i][j]==1) {
					count++;
					reset[i][j]=count;
					Labeling_DFS(i,j);
				}
			}
		}
		Reset();	//arr�Լ��� reset �Լ��� �ʱ�ȭ �����ش� (����)
		
		//���� ����� �ٸ����̸� ã�� ����
		//������ �����Ͽ� �ٸ� ���� ���� ���� ������ �� ���� �����ϰ� ���ƿ´�
		//���� ��� �������� Ȯ���Ѵ�. �����¿쿡 ���� ���� �� �ְ� �ִܰŸ��� �� �� �����Ƿ�
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
			//��ǥ �Ѿ�� �н�
			if( nx<0 || ny <0 || nx>=N || ny >=N) {
				continue;
			}
			//���� �� ��ġ�� ���� ���̸� �н�
			if(reset[nx][ny] ==count) {
				continue;
			}
			//���� �� ��ġ�� �ٴ��̸� �н�
			if(reset[nx][ny]==0) {
				continue;
			}
			//���� ��ȣ�� count�� �����Ѵ� (count�� 2,3,4 ���� ������ �����Ѵ�)
			reset[nx][ny] = count;
			Labeling_DFS(nx, ny);
		}
	}
	
	public static void ShortestPath_BFS(int x, int y) {
		
		//inX, inY�� ��� ���� ���� �����ϱ� ���� ��ǥ�̴�. 
		int inX = x;	//��� ���� x��ǥ
		int inY = y;	//��� ���� y��ǥ
		Queue<DOT> q = new LinkedList<>();
		q.add(new DOT(x, y, 0));
		
		while(!q.isEmpty()) {
			DOT current = q.poll();
			for(int i=0; i<4; i++) {
				//���� ��ô����� ��ġ ��ǥ�� �Ÿ� ���� ����
				int nX = current.x + dx[i];
				int nY = current.y + dy[i];
				int nextCount = current.count + 1;
				if(nX <0 || nY <0 || nX>=N ||nY>=N) {
					continue;
				}
				//���� ��ô�� �ڸ��� �̹� ���̶�� �н�
				if(arr[nX][nY]== arr[inX][inY]) {
					continue;
				}
				//���� ��ô�� �ڸ��� �̹� ��ô�� �ڸ���� �н�
				if(arr[nX][nY]==-1) {
					continue;
				}
				//���� ��ô�� �ڸ��� �ٴٰ� �ƴ϶��
				//�̹� ���� ��ô�ڸ��� ���� ���ǿ� �ɷ����Ƿ� �� ������ ���� ������ �ٸ� ���̴�
				if(arr[nX][nY]!=0) {
					//�ٸ� ���� ������������ �ִ� �Ÿ��� ���Ͽ� ����. �׸��� ����
					min = Math.min(min, nextCount-1);
					return;
				}
				//��ô�� �ڸ��� -1�� ���´�. �׸��� ť�� �ִ´�.
				arr[nX][nY]= -1;
				q.add(new DOT(nX, nY, nextCount));
			}
		}
	}
	
	//��ô ������� ���� -1�� ���� �ڸ��� �ǵ��� ���� �ٸ� �ִܰŸ��� ���� �� �ִ�
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



