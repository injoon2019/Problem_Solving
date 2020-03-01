//Baekjoon - 11726
//저장할 수 있는 수의 범위가 없다면 마지막이 아닌 중간에 %10007을 하는 것과 마지막에 %10007을 하는 것의 결과가 똑같음을 증명할 수 있습니다. 
//여기서는 수가 int 범위까지만 갈 수 있기 때문에 중간에 %10007을 안 하면 오히려 잘못된 값으로 오버플로우하게 됩니다.
//직감적으로 와닿지 않는다면 10진수의 수에서 일의 자리만 구하는 경우를 생각해보시면 됩니다. 덧셈과 곱셈만으로 이루어진 연산들에서 10의 자리를 넘어가는 건 아무 의미가 없으니, 
//매 연산마다 그 1의 자리 하나만 추적하고 있어도 결과는 똑같이 나옵니다. 마찬가지로, 이 수를 10007진수라고 생각하고 끝자리 한 자리만 추적해도 결과는 같습니다.
import java.io.*;
public class BaekJoon11726 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		long [] dp = new long [N+1];
		
		for(int i=0; i<=N; i++) {
            if(i <= 2) dp[i] = i;
            else {
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            }
        }
		
		sb.append(dp[N]);
		
		bw.append(sb);
		bw.flush();
	}	
}