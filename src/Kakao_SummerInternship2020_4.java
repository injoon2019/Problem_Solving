
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

		// ���� 0, y�� ���󰡰� �־��� �� 1, x�� ���󰡰� �־��� �� 2
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

					if (r == 0 && c == 0) { // ��ó�� ����
						System.out.println("-------------------");
						if (nx == 1 && ny == 0) { // �������� x������ ������ 1ĭ
							newDir = 2;
						} else if (ny == 1 && nx == 0) { // �������� y�� ������ ��ĭ
							newDir = 1;
						}
					} else {
						if (c != nx && dir==1) {// y�� ���󰡴� x ���� �ٲ�����
							newCost += 500;
							newDir = 2;
						} else if (r != ny && dir==2) { // x�� ���󰡴� y���� �ٲ��
							newCost += 500;
							newDir = 1;
						}else {	//�ȹٲ��
							
						}
					}

					dfs(board, ny, nx, newDir, cost+newCost);
				}
				visited[r][c] = false;
			}
			
		}
		

	}

}
