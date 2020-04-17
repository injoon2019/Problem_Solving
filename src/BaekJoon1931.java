//Baekjoon - 1931
import java.io.*;
import java.util.*;

public class BaekJoon1931 {
	 
    public static void main(String[] args) throws IOException {
    	
    	class Time implements Comparable<Time>{
    		int start;
    		int finish;
    		Time(int start, int finish){
    			this.start = start;
    			this.finish = finish;
    		}
			@Override
			public int compareTo(Time o) {
				if(this.finish<o.finish) {
					return -1;
				}
				else if (this.finish == o.finish) {
					if(this.start< o.start) {
						return -1;
					}else if(this.start == o.start) {
						return 0;
					}else {
						return 1;
					}
				}else {
					return 1;
				}
			}
    		
    	}   	
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Time[] arr = new Time[N];
        
        for(int i=0; i<N; i++) {
        	String[] strToken = br.readLine().split(" ");
        	Time time = new Time(Integer.parseInt(strToken[0]), Integer.parseInt(strToken[1]));
        	arr[i] = time;
        }
        Arrays.parallelSort(arr);
//        for(int i=0;  i<arr.length; i++) {
//        	System.out.println(arr[i].start+" "+arr[i].finish);
//        }
        
        int count=0, last=0;
        for(int i=0; i<N; i++) {
        	if(arr[i].start>=last) {
        		count++;
        		last = arr[i].finish;
        	}
        }
        System.out.println(count);
    }
}

