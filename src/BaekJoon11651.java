//Baekjoon - 11651

import java.io.*;
import java.util.Arrays;
public class BaekJoon11651 {
	
	public static void main(String[] args)throws Exception{
		class Point implements Comparable<Point>{
			int x,y;
			Point(int x, int y){
				this.x = x;
				this.y = y;
			}
			@Override
			public int compareTo(Point o) {
				if(this.y < o.y) {
					return -1;
				}else if(this.y == o.y){
					if(this.x < o.x) {
						return -1;
					}else if(this.x == o.x) {
						return 0;
					}else {
						return 1;
					}
				}else {
					return 1;
				}
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		String[] strToken;
		Point[] pArr = new Point[n];
		int x, y;
		for(int i=0; i<n; i++) {
			strToken= br.readLine().split(" ");
			x = Integer.parseInt(strToken[0]);
			y= Integer.parseInt(strToken[1]);
			pArr[i]= new Point(x,y);
		}
		Arrays.sort(pArr);
		for(Point p: pArr) {
			System.out.printf("%d %d\n", p.x, p.y);
		}

	}	
}