//Baekjoon - 2156
import java.io.*;
public class BaekJoon2156 {
//	public static void main(String[] args) throws IOException{
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		int[] num = new int[n+1];
//		for(int i=1; i<num.length; i++){
//			num[i] = Integer.parseInt(br.readLine());
//		}
//		if(n==1){
//			System.out.println(num[n]);
//			return;
//		}
//		int[] d = new int[n+1];
//		d[1]=num[1];
//		d[2]= num[1]+num[2];//i-3까지 들어가기 때문에
//		if(n!=1&&n!=2){
//		for(int i=3; i<=n; i++){
//			//0번 연속
//			d[i] = d[i-1];
//			//1번 연속
//			if(d[i]<d[i-2]+num[i])
//				d[i]=d[i-2]+num[i];
//			//2번연속
//			if(d[i]<d[i-3]+num[i]+num[i-1])
//				d[i]=d[i-3]+num[i]+num[i-1];
//		}
//		}
//		System.out.println(d[n]);
//	}
	
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[2][T];
		int[] arr = new int[T];
		for(int i=0; i<T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//dp[i][j] = dp[0][j]는 j번째까지 그 이전잔을 안마셨을 때의 최대값을 나타내고, 
		//		          dp[1][j]는 그 이전 잔을 마셨을 때의 최대값을 나타낸다. 
		dp[0][0]=arr[0];
		dp[1][0]=arr[0];
		if(T>1) {
			dp[0][1] = arr[1];
			dp[1][1] = arr[0]+arr[1];
		}
		for(int i=2; i<T; i++) {
			//앞에 것을 안먹은 경우 두 가지 케이스가 있다. 1. 앞앞꺼를 먹은 경우 2. 앞앞꺼를 안 먹은 경우 
			//앞에 것을 안먹은 경우 그러나 앞앞 것을 먹은경우
			int tmpMax= Math.max(dp[1][i-2], dp[0][i-2]);
			//앞에 것을 안먹은 경우 그리고 앞앞 것도 안먹은 경우 
			if(i>=3) {
				tmpMax = Math.max(tmpMax, dp[1][i-3]);
				tmpMax = Math.max(tmpMax, dp[0][i-3]);
			}
			
			dp[0][i] = tmpMax + arr[i] ;
			//앞에 것을 먹은 경우
			dp[1][i] = dp[0][i-1] + arr[i];
			
		}
		
		int max=dp[1][0];
		for(int i=0; i<T; i++) {
			max= Math.max(max,  dp[1][i]);
			max= Math.max(max, dp[0][i]);
		}
		System.out.println(max);

	}	
}