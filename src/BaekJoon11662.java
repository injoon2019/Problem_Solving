//Baekjoon - 11662
//https://mslim8803.tistory.com/13
//https://m.blog.naver.com/PostView.nhn?blogId=kks227&logNo=221432986308&proxyReferer=https:%2F%2Fwww.google.com%2F
import java.io.*;
import java.util.*;

public class BaekJoon11662 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double aX1  = Double.parseDouble(st.nextToken());
		double aY1  = Double.parseDouble(st.nextToken());
		double aX2  = Double.parseDouble(st.nextToken());
		double aY2  = Double.parseDouble(st.nextToken());
		double cX1  = Double.parseDouble(st.nextToken());
		double cY1  = Double.parseDouble(st.nextToken());
		double cX2  = Double.parseDouble(st.nextToken());
		double cY2  = Double.parseDouble(st.nextToken());
		
		int interval = 1000000;
		
		double aDX = (aX2-aX1) / interval;
		double aDY = (aY2-aY1) / interval;
		double cDX = (cX2-cX1) / interval;
		double cDY = (cY2-cY1) / interval;
		
		double min =  getDistance(aX1, aY1, cX1, cY1);
		
		for(int i=1; i<=interval; i++) {
			double tmp = getDistance(aX1 + aDX*i, aY1+ aDY*i, cX1+cDX*i, cY1+cDY*i);
			
			if(tmp<min) {
				min = tmp;
			}
		}
		System.out.println(min);
	}
	
	private static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
	}
}
