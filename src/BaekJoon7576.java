//Baekjoon - 7576 �丶��
import java.io.*;
import java.util.*;

public class BaekJoon7576 {

	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = { 0, 1,-1, 0};
	static int[][] visited;
	static int[][] map;
	static int day=0;
	static int X, Y;
	static boolean change = false;
	
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");
		X = Integer.parseInt(strToken[0]);
		Y = Integer.parseInt(strToken[1]);
		map = new int[Y][X];
		visited = new int[Y][X];
		boolean allZero = true;
		
		for(int i=0; i<Y; i++) {
			strToken = br.readLine().split(" ");
			for(int j=0; j<X; j++) {
				map[i][j] = Integer.parseInt(strToken[j]);
				if(map[i][j]!=0)
					allZero=false;
			}
		}

		bfs();
		
	}
	
	static void bfs() {
		Queue<DOT> queue = new LinkedList<>();
		
		for(int i=0; i<Y; i++) {
			for(int j=0; j<X; j++) {
				if(map[i][j]==1) {
					//���� �丶�䰡 �ִ� ��� ��ġ�� ť�� �ٴ´�
					queue.add(new DOT(i,j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			//���� �丶���� �����¿�� ������ �ͱ� ������ ť�� ��ƾ��Ѵ�
			DOT dot = queue.poll();
			for(int i=0; i<4; i++) {
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];
				
				//���� �� �н�
				if(nx>=0 && ny>=0 && nx<X && ny<Y) {
					if(map[ny][nx]==0) {
						//�ִ� �ϼ��� ���ϱ� ������ 1�� �ٲٴ� ���� �ƴ϶� ���� �ϼ� +1�� ���ش�?
						map[ny][nx] = map[dot.y][dot.x]+1;
						queue.add(new DOT(ny,nx));
					}
				}
			}
		}
		for(int i=0; i<Y; i++) {
			for(int j=0; j<X; j++) {
				if(map[i][j]==0) {
					//��ī�䰡 �ϳ��� ���� ���� ��Ȳ�̶�� -1 ���
					System.out.println(-1);
					return;
				}
				day = Math.max(day, map[i][j]);
			}
		}
		System.out.println(day-1);
		
		
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
