//Baekjoon - 9466
import java.io.*;
import java.util.*;

public class BaekJoon9466 {

	public static void main(String[] args)throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr;
		String[] strToken;
 		int T = Integer.parseInt(br.readLine());
 		boolean[] done;
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			done = new boolean[n+1];
			strToken = br.readLine().split(" ");
			for(int i=1; i<=n; i++) {
				arr[i]= Integer.parseInt(strToken[i-1]);
			}
			int count = 0;
			int tmp=0;
			for(int i=1; i<=n; i++) {
				if(done[i]==true)
					continue;
				
				if(arr[i]==i) {
					count++;
					continue;
				}
				tmp = arr[i];
				int tmp2=0;
				for(int k=1; k<=n; k++) {
					if(tmp == i) {
						count++;
						tmp2 =arr[i];
						while(tmp2!=i) {
							//System.out.print(tmp2);
							done[tmp2]=true;
							tmp2=arr[tmp2];
						}
						break;
					}
					tmp = arr[tmp];
				}
			}
			
			System.out.println(n-count);
		}
	}	
}