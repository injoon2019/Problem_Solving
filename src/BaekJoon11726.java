//Baekjoon - 11726
//������ �� �ִ� ���� ������ ���ٸ� �������� �ƴ� �߰��� %10007�� �ϴ� �Ͱ� �������� %10007�� �ϴ� ���� ����� �Ȱ����� ������ �� �ֽ��ϴ�. 
//���⼭�� ���� int ���������� �� �� �ֱ� ������ �߰��� %10007�� �� �ϸ� ������ �߸��� ������ �����÷ο��ϰ� �˴ϴ�.
//���������� �ʹ��� �ʴ´ٸ� 10������ ������ ���� �ڸ��� ���ϴ� ��츦 �����غ��ø� �˴ϴ�. ������ ���������� �̷���� ����鿡�� 10�� �ڸ��� �Ѿ�� �� �ƹ� �ǹ̰� ������, 
//�� ���긶�� �� 1�� �ڸ� �ϳ��� �����ϰ� �־ ����� �Ȱ��� ���ɴϴ�. ����������, �� ���� 10007������� �����ϰ� ���ڸ� �� �ڸ��� �����ص� ����� �����ϴ�.
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