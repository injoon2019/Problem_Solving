//Baekjoon - 11021
import java.io.*;
public class AplusB7 {
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			String[] strToken= br.readLine().split(" ");
			System.out.println("Case #"+(i+1)+": "+(Integer.parseInt(strToken[0])+Integer.parseInt(strToken[1])));
		}
	}
}
