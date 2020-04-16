//Baekjoon - 2875
import java.io.*;
import java.util.*;

public class BaekJoon2875 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strToken = br.readLine().split(" ");
        int N = Integer.parseInt(strToken[0]);
        int M = Integer.parseInt(strToken[1]);
        int K = Integer.parseInt(strToken[2]);
        
        int ans = 0;
        
        while(K-- > 0) {
        	if(getCount(N, true) >= getCount(M, false)) {
        		N--;
        	}else {
        		M--;
        	}
        }
        
        ans = N/2 <= M? N/2 : M;
        System.out.println(ans);
    }
    
    public static int getCount(int n, boolean female) {
    	if(female) {
    		n = n/2;
    	}
    	return n;
    }
}
