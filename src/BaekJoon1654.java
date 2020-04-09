//Baekjoon - 1654 랜선 자르기
import java.io.*;
import java.util.*;

public class BaekJoon1654 {
	
	public static void main(String[] args) throws Exception {		
		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();	//이미 가지고 있는 랜선의 개수
		int N = scan.nextInt();	//필요한 랜선의 개수 
		long[] arr = new long[K];
		for(int i=0;  i<K; i++) {
			arr[i]= scan.nextInt();
		}
		Arrays.parallelSort(arr);
		long max = arr[K-1];	//mid를 구하는 과정에서 min과 max를 더하면 모두 int 범위를 넘을 수 있음
		long min = 1;	//문제에서 랜선 길이는 자연수라 했으므로 0으로 초기화하면 에러 발생
		long mid = 0;
		long count = 0;
		while(min<=max) {
			mid = (max+min)/2;
			count=0;
			for(int i=0; i<K;i++) {
				count += arr[i]/mid;
			}
			
			if(count >=N) {	//처음에는 ==이되면 break를 걸었는데, 그건 구체적인 수를 찾을 때는 가능하지만
				min = mid+1;	//문제처럼 가능한 경우의 수 중에서 최대값을 구할 경우에는 부등호 처리를 해야한다
			}					//==이 아니더라도 답이 되는 경우가 존재한다
			else if(count<N){
				max = mid-1;
			}
		}
		System.out.println(max);	//왜 mid가 아닌 max가 답일까?
	}
}



