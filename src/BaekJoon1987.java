//Baekjoon - 1987 ¾ËÆÄºª

import java.io.*;
import java.util.*;


public class BaekJoon1987 {
	static int R, C;
	static char[][] arr;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static boolean[] check = new boolean[26];
	static int MAX = Integer.MIN_VALUE;
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");
		String str;
		R = Integer.parseInt(strToken[0]);
		C = Integer.parseInt(strToken[1]);
		arr = new char[R][C];
		
		for(int i=0; i<R; i++) {
			str = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		dfs(0,0,0);
		System.out.println(MAX);
	}	
	
	public static void dfs(int r, int c, int count) {
		if(check[arr[r][c]-'A']==true)
			return;
		
		else {
			check[arr[r][c]-'A']=true;
			count++;
			if(count>MAX)
				MAX=count;
			
			for(int i=0; i<4; i++) {
				int ny = r+ dx[i];
				int nx = c+ dy[i];
				if((ny>=0&& ny<R)&&(nx>=0&&nx<C)) {
					//System.out.println(ny+" "+nx);
					dfs(ny, nx, count);
				}
			}
			count--;
			check[arr[r][c]-'A']=false;
		}
	}
}