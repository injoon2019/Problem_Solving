//Baekjoon - 1924
import java.io.*;
public class TwothousandSeven {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x, y;
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31}; 
		String[] DAY= { "SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int daysSum=0;
		String[] strToken= br.readLine().split(" ");
		x = Integer.parseInt(strToken[0]);
		y= Integer.parseInt(strToken[1]);
		
		if(x !=1) {
			for(int i=0; i<x-1; i++) {
				daysSum += days[i];
			}
		}
		
		daysSum+=y;
		daysSum %= 7;
		System.out.println(DAY[daysSum]);
		
		
		
	}
}

