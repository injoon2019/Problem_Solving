//Baekjoon - 11650

import java.io.*;
import java.util.*;
public class BaekJoon11650_2 {

	public static void main(String[] args)throws Exception{
		class DOT implements Comparable<DOT>{
			int x, y;
			DOT(int x, int y){
				this.x = x;
				this.y = y;
			}
			@Override
			public int compareTo(DOT o) {
				if(this.x - o.x <0) {
					return -1;
				}else if(this.x == o.x) {
					return this.y - o.y;
				}else {
					return 1;
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		DOT[] arr = new DOT[N];
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[i] = new DOT(x,y);
		}
		Arrays.parallelSort(arr);
		for(DOT tmp : arr) {
			System.out.print(tmp.x+" "+tmp.y+"\n");
		}
		
	}	
}