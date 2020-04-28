//Baekjoon - 2186 ������ 
import java.io.*;
import java.util.*;
public class BaekJoon2186 {
	
	static int R,C,K;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static char[][] arr;
	static String target;
	//(-1:�湮���� �ʾҴ�, 0: �湮�ߴµ� �������� �ʾҴ�, 1:�����ϴ�)
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
		//������ ���ڿ����� �����̴�
		if(cnt== target.length()-1) {
			dp[row][col][cnt] =1;
			return 1;
		}
		//�湮�� ���̶�� �����ߴ� dp�� Ȱ���Ѵ�
		if(dp[row][col][cnt]!= -1)
			return dp[row][col][cnt];
		
		//���ڰ� ���� ������ 0���� ä���
		if(arr[row][col] != target.charAt(cnt)) {
			dp[row][col][cnt]=0;
			return 0;
		}
		
		dp[row][col][cnt]=0;
		
		for(int i=0; i<4; i++) {
			for(int k=1; k<=K; k++) {
				int nx = col+ dx[i]*k;
				int ny = row + dy[i]*k;
				
				//���� ����ų� ���� ���ڰ� ���� ���ڿ��� �ٸ� ���
				if(!check(nx, ny) || arr[ny][nx]!=target.charAt(cnt+1))
					continue;
				
				//���� ��ġ�� ������ ���
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

