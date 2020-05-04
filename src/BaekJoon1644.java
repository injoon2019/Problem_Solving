//Baekjoon - 1644 소수의 연속합
import java.io.*;
import java.util.*;

public class BaekJoon1644 {
    static boolean[] erathos = new boolean[4000001];
    static int[] consecutivePrime = new int[2000000];
    static int N;
    static int cnt;
    static int consecutiveCount=0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        erathos();
        int first=0, last=0;
        int sum = 0;
        
        while(last<=consecutiveCount ) {
        	if(sum>N) {
        		sum -= consecutivePrime[first++];
        	}else if(sum== N) {
        		cnt++;
        		sum += consecutivePrime[last++];
        	}else {
        		sum += consecutivePrime[last++];
        	}
        }
        
        System.out.println(cnt);
    }
    
    public static void erathos() {
    	for(int i=2; i*i<=4000000; i++) {
    		if(erathos[i]) {
    			continue;
    		}
    		
    		for(int j=i+i; j<=4000000; j+=i) {
    			erathos[j]=true;
    		}
    	}
    	
    	for(int i=2; i<=4000000; i++) {
    		if(erathos[i]==false) {
    			consecutivePrime[consecutiveCount++] = i;
    		}
    	}
    }
}
