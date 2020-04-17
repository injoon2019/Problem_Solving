//Baekjoon - 1783
import java.io.*;
import java.util.*;

public class BaekJoon1783 {
	 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] strToken = br.readLine().split(" ");
        int N = Integer.parseInt(strToken[0]);
        int M = Integer.parseInt(strToken[1]);
        
        if(N==1)	//세로 한칸이면 움직일 수 없다
        	System.out.println("1");
        else if (N==2)	//세로가 두 칸이면 2와 3번만 가능 (3회까지만 움직일 수 없다)
        	System.out.println(Math.min(4, (M+1)/2));
        //1,2,3,4번이 적어도 한번씩은 나와야 한다
        else if (N>=3) {
        	//가로가 6까지는 최대 4칸 (1,4,2,3)
        	if(M<=6)
        		System.out.println(Math.min(4, M));
        	else	//2번 3번 한번씩 나머지는 1,2번
        		System.out.println(M-2);
        		
        }
    }
}
