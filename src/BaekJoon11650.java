//Baekjoon - 11650

import java.io.*;
import java.util.Arrays;
public class BaekJoon11650 {
	
	public static void main(String[] args)throws Exception{
		class Point implements Comparable<Point>{
			int x,y;
			Point(int x, int y){
				this.x= x;
				this.y = y;
			}
			//정렬에 있어서 앞에 오고 싶을 때 음수를 내보내면 된다.
			@Override
			public int compareTo(Point o) {
				if(this.x< o.x) {
					return -1;
				}else if(this.x== o.x) {
					if(this.y <o.y) {
						return -1;
					}else if(this.y== o.y) {
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
		Point[] pArr = new Point[n];
		String[] strToken;
		for(int i=0; i<n; i++) {
			strToken = br.readLine().split(" ");
			int x = Integer.parseInt(strToken[0]);
			int y = Integer.parseInt(strToken[1]);
			pArr[i] = new Point(x, y);
		}
		Arrays.sort(pArr);
		for(Point p: pArr) {
			System.out.printf("%d %d\n", p.x, p.y);
		}
	}	
}