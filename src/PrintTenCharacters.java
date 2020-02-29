//Baekjoon - 11721
import java.io.*;
public class PrintTenCharacters {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str= br.readLine();
		for(int i=0; i<str.length(); i++) {
			System.out.printf("%c", str.charAt(i));
			if(i>=9 && i %10 ==9) {
				System.out.println();
			}
		}
	}

	
}