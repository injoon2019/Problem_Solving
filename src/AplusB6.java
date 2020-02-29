//Baekjoon - 10952
import java.io.*;
public class AplusB6 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String str=  br.readLine();
			String[] strToken = str.split(",");
			System.out.println( Integer.parseInt(strToken[0]) + Integer.parseInt(strToken[1]));
		}
	}
}
