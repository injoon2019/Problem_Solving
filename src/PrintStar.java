//Baekjoon - 2438
import java.io.*;
public class PrintStar {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<= i; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		bw.append(sb);
		bw.flush();
	}	
}