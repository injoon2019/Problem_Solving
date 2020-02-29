//Baekjoon - 2440
import java.io.*;
public class PrintStar3 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			for(int j=N; j>=i; j--) {
				sb.append("*");
			}

			sb.append('\n');
		}
		bw.append(sb);
		bw.flush();
	}	
}