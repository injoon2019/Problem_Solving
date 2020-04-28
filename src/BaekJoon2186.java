//Baekjoon - 2186 문자판 
import java.io.*;
import java.util.*;
public class BaekJoon2186 {
	
	static int R,C,K;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static char[][] arr;
	static String target;
	//(-1:방문하지 않았다, 0: 방문했는데 유망하지 않았다, 1:유망하다)
	static int[][][] dp;
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");
		R = Integer.parseInt(strToken[0]);
		C = Integer.parseInt(strToken[1]);
		K = Integer.parseInt(strToken[2]);
		arr = new char[R][C];
		String str;
		
		for(int i=0; i<R; i++) {
			str = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		target = br.readLine();
		dp = new int[R][C][target.length()];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		
		int ans = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				ans += dfs(i,j, 0);
			}	
		}
		System.out.println(ans);
		
	}
	
	public static int dfs(int row, int col, int cnt) {
		//마지막 문자열까지 정답이다
		if(cnt== target.length()-1) {
			dp[row][col][cnt] =1;
			return 1;
		}
		//방문한 곳이라면 저장했던 dp를 활용한다
		if(dp[row][col][cnt]!= -1)
			return dp[row][col][cnt];
		
		//문자가 맞지 않으면 0으로 채운다
		if(arr[row][col] != target.charAt(cnt)) {
			dp[row][col][cnt]=0;
			return 0;
		}
		
		dp[row][col][cnt]=0;
		
		for(int i=0; i<4; i++) {
			for(int k=1; k<=K; k++) {
				int nx = col+ dx[i]*k;
				int ny = row + dy[i]*k;
				
				//맵을 벗어나거나 다음 문자가 정답 문자열과 다른 경우
				if(!check(nx, ny) || arr[ny][nx]!=target.charAt(cnt+1))
					continue;
				
				//다음 위치가 유망할 경우
				dp[row][col][cnt] += dfs(ny,nx,cnt+1);
			}
		}
		return dp[row][col][cnt];
		
	}
	static boolean check(int x, int y) {
		if(x<0 || x>=C || y<0 || y>=R)
			return false;
		return true;
	}
}

