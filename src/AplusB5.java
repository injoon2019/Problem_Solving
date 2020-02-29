//Baekjoon - 10952
import java.io.*;
public class AplusB5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str ="";
		while((str = br.readLine())!= null) {
			String[] strToken = str.split(" ");
			int a = Integer.parseInt(strToken[0]);
			int b = Integer.parseInt(strToken[1]);
			
			if(a==0 && b==0) {
				return;
			}
			
			System.out.println(a+b);
		}
	}
}
