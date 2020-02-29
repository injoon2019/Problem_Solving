import java.io.*;
public class AplusB4 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String value = "";
		
		while((value = br.readLine()) !=null) {
			String[] strToken = value.split(" ");
			int sum = 0;
			
			for(String string : strToken) {
				sum+= Integer.parseInt(string);
			}
			
			bw.write(Integer.toString(sum)+"\n");
		}
		
		bw.flush();
		if (bw!=null) bw.close();
	}
}
