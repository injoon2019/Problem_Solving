//Baekjoon - 11719
import java.io.*;
public class PrintAsItIs2 {
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while((str=br.readLine())!=null) {
			System.out.println(str);
		}
	}
}