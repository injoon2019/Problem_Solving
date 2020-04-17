//Baekjoon - 10610
import java.io.*;
import java.util.*;

public class BaekJoon10610 {
	 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        
        int[] arr = new int[str.length()];
        
        for(int i=0; i<arr.length; i++) {
        	arr[i] = str.charAt(i)-'0';
        }
        
        Arrays.sort(arr);
        
        int sum = 0;
        for(int i=arr.length-1; i>=0; i--) {
        	sum += arr[i];
        }
        
        
        if(sum%3==0 && arr[0]==0) {
            for(int i=arr.length-1; i>=0; i--) {
            	System.out.print(arr[i]);
            }
        }
        else {
        	System.out.println("-1");
        }
    }
}
