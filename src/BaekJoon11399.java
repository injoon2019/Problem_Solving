//Baekjoon - 11399
import java.io.*;
import java.util.*;

public class BaekJoon11399 {
	 
    public static void main(String[] args) throws IOException {    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] strToken = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
        	arr[i]= Integer.parseInt(strToken[i]);
        }
        Arrays.sort(arr);
        int sum=0;
        int cur=0;
        for(int i=0; i<arr.length;  i++) {
        	cur=0;
        	for(int j=0; j<i; j++) {
        		cur+=arr[j];
        	}
        	sum+= cur+ arr[i];
        }
        System.out.println(sum);
        
    }
}

