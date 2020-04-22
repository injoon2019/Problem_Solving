//Baekjoon - 1744
import java.io.*;
import java.util.*;

public class BaekJoon1744 {
	static int N;
	static ArrayList<Integer> PLUS = new ArrayList<Integer>();
	static ArrayList<Integer> MINUS= new ArrayList<Integer>();
	
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
        	int num = scan.nextInt();
        	if(num>0)
        		PLUS.add(num);
        	else
        		MINUS.add(num);
        }
        Collections.sort(PLUS);
        Collections.sort(MINUS);
        int max = 0;
        for(int i=PLUS.size()-1; i>=0; i-=2) {
        	if(i>0)
        		max += Math.max(PLUS.get(i)*PLUS.get(i-1), PLUS.get(i)+PLUS.get(i-1));
        	else
        		max += PLUS.get(i);
        }
        for(int i=0; i<MINUS.size(); i+=2) {
        	if(i == MINUS.size()-1)
        		max += MINUS.get(i);
        	else
        		max += Math.max(MINUS.get(i)*MINUS.get(i+1), MINUS.get(i)+MINUS.get(i+1));
        }
        System.out.println(max);
        int a=1;
        int b=0;
        
    }
}
