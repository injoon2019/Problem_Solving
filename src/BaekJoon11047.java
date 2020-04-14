//Baekjoon - 11047
//https://dundung.tistory.com/52
import java.io.*;
import java.util.*;

public class BaekJoon11047 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strToken = br.readLine().split(" ");
        int N = Integer.parseInt(strToken[0]);
        int amount = Integer.parseInt(strToken[1]);
        int count = 0;
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
        	strToken = br.readLine().split(" ");
        	arr[i]= Integer.parseInt(strToken[0]);
        }
        
        for(int i=arr.length-1; i>=0; i--) {
        	if(amount> arr[i]) {
        		int div = amount / arr[i];
        		count += div;
        		amount = amount % arr[i];
        	}
        }
        System.out.println(count);
    }
 
}
