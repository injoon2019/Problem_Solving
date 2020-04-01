//Baekjoon - 4963 ¼¶ÀÇ °³¼ö
import java.io.*;
import java.util.*;

public class BaekJoon4963 {

	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	static int[] dy = {-1,  0,  1,-1, 0, 1,-1, 0, 1};
	static int cnt=0;
	static int w, h;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] strToken = br.readLine().split(" ");
			cnt= 0;
			w = Integer.parseInt(strToken[0]);
			h = Integer.parseInt(strToken[1]);
			if(w==0 && h==0) {
				break;
			}
			map = new int[h][w];
			visited= new int[h][w];
			for(int i=0; i<h; i++) {
				strToken = br.readLine().split(" ");
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(strToken[j]);
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]==1 && visited[i][j]==0) {
						find(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
	
	static void find(int y, int x) {
		visited[y][x] = 1;
		for(int i=0; i<9; i++) {
			int nx = x + dx[i];
			int ny = y+ dy[i];
			
			if(nx>=0 && ny>=0 && nx<w && ny<h) {
				if(map[ny][nx]==1 && visited[ny][nx]==0) {
					find(ny, nx);				
				}
			}
		}
	}
}
