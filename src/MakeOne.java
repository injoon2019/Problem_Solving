//Baekjoon - 1463
import java.io.*;
import java.lang.*;
import java.util.Arrays; 
import java.util.Scanner;


/* Top down */
import java.util.Scanner;
 
public class MakeOne {
    static int[] d;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1];
 
        System.out.println(dp(n));
        sc.close();
    }
 
    private static int dp(int n) {
        if (n == 1)
            return 0;
        if (d[n] > 0)
            return d[n];
        d[n] = dp(n - 1) + 1;
        if (n % 2 == 0) {
            int tmp = dp(n / 2) + 1;
            if (d[n] > tmp)
                d[n] = tmp;
        }
        if (n % 3 == 0) {
            int tmp = dp(n / 3) + 1;
            if (d[n] > tmp)
                d[n] = tmp;
        }
        return d[n];
    }
}

/* Bottom Up */

//import java.util.Scanner;
 
//public class Beak1463 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int dp[] = new int[n + 1];
//        dp[0] = dp[1] = 0;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + 1;
//            if (i % 2 == 0)
//                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
//            if (i % 3 == 0)
//                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
//        }
//        System.out.println(dp[n]);
//        sc.close();
//    }
//}
//public class MakeOne {
//	
//	public static void main(String[] args)throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		
//		int[] ans = new int[N+1];
//		
//		ans[1]=0;
//		if(N>=2) {
//			ans[2]=1;			
//		}
//		if(N>=3) {
//			ans[3]=1;
//		}
//
//		int result=0;
//		if(N>=4) {
//			for(int i=4;i<=N; i++) {
//				int[] tmp = new int[3];
//				
//				if(i%2 ==0) {
//					tmp[0]= ans[i/2]+1;
//				}if( i%3 == 0) {
//					tmp[1] = ans[i/3]+1;
//				}if( i-1 >0) {
//					tmp[2] = ans[i-1]+1;
//				}
//				
//				Arrays.sort(tmp);
//
//				for(int k=0; k<3; k++) {
//					if(tmp[k] !=0) {
//						result = tmp[k];
//						break;
//					}
//				}
//				ans[i]= result;
//			}
//		}
//		System.out.println(ans[N]);
//	}	
//}


