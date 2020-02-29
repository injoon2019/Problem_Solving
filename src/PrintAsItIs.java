//Baekjoon - 11718
import java.io.*;
public class PrintAsItIs {
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while((str=br.readLine())!=null) {
			System.out.println(str);
		}
	}
}