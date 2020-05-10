
//Kakao Summer Internship 2020_4
import java.io.*;
import java.util.*;

public class Kakao_SummerInternship2020_4 {
	static int[][] dist;
	static int[][] costMap;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, 1, -1, 0 };
	static int R;
	static int C;
	static int result;
	static int minCost = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// int[][] board = {{0,0,1,0}, {0,0,0,0}, {0,1,0,1}, {1,0,0,0}};
		int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		System.out.println("answer:"+minCost);

	}

	public static int solution(int[][] board) {
		int answer = 0;
		R = board.length;
		C = board[0].length;
		dist = new int[R][C];
		costMap =new int[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		// 시작 0, y축 따라가고 있었을 때 1, x축 따라가고 있었을 때 2
		dfs(board, 0, 0, 0, 0);
		answer = minCost;
		return answer;
	}

	public static void dfs(int[][] board, int r, int c, int dir, int cost) {

		if (r == R - 1 && c == C - 1) {
			if(cost < minCost) {
				minCost = cost;
			}
			return;
		}else {
			
			for (int i = 0; i < 4; i++) {
				visited[r][c] = true;
				int ny = r + dy[i];
				int nx = c + dx[i];

				int newCost = 100;
				int newDir = 0;
				if (ny >= 0 && nx >= 0 && ny < R && nx < C ) {
					if (board[ny][nx] == 1 || visited[ny][nx]==true) {
						continue;
					}

					if (r == 0 && c == 0) { // 맨처음 시작
						System.out.println("-------------------");
						if (nx == 1 && ny == 0) { // 원점에서 x축으로 오른쪽 1칸
							newDir = 2;
						} else if (ny == 1 && nx == 0) { // 원점에서 y축 밑으로 한칸
							newDir = 1;
						}
					} else {
						if (c != nx && dir==1) {// y축 따라가다 x 값이 바꼈으면
							newCost += 500;
							newDir = 2;
						} else if (r != ny && dir==2) { // x축 따라가다 y값이 바뀐거
							newCost += 500;
							newDir = 1;
						}else {	//안바뀐거
							
						}
					}

					dfs(board, ny, nx, newDir, cost+newCost);
				}
				visited[r][c] = false;
			}
			
		}
		

	}

}
