//Baekjoon - 2739
import java.io.*;

public class Gugudan {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int dan = Integer.parseInt(br.readLine());
		for(int i=1; i<=9; i++) {
			sb.append(dan).append(" * ").append(i).append(" = ").append(dan*i).append('\n');
		}
		bw.append(sb);
		bw.flush();
	}
}
