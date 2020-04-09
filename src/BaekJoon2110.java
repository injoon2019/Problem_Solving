//Baekjoon - 2110 ������ ��ġ 
import java.io.*;
import java.util.*;

public class BaekJoon2110 {
    static boolean check(int[] a, int dist, int c) {
        int cnt = 1;
        int last = a[0]+dist; //ù ��° �� + �Ÿ�
        for(int i=0; i<a.length; i++) {
            if(a[i] >= last) {
                cnt++;
                last = a[i]+dist; //������ �� + �Ÿ�
            }
        }
        return cnt >= c;
    }
	public static void main(String[] args) throws Exception {		
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        int [] a = new int[n];
        
        for(int i=0; i<n; i++){
            a[i] = scan.nextInt();
        }
        
        Arrays.sort(a);
        int ans = 1;
        int start = 1;
        int end = a[n-1]-a[0]; //������ �ִ� �Ÿ�
        
        while (start <= end) {
            int mid = (start+end)/2;
            if (check(a, mid, c)) {
                ans = Math.max(ans,mid);
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        System.out.println(ans);
	}
}



