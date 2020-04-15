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
        
        int[] arr = new int[K+1];
        
        for(int i=0; i<=K; i++) {
        	int tmp = (N-i)/2;
        	int min =Math.min(tmp, (M-(K-i)));
        	if(min>=0) {
        		arr[i]=min;
        	}
        }
        
        int max = 0;
        for(int i=0; i<=K; i++) {
        	if(arr[i]>max) {
        		max = arr[i];
        	}
        }

        System.out.println(max);
    }
}
