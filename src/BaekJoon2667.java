//Baekjoon - 9466
import java.io.*;
import java.util.*;

public class BaekJoon2667 {
	static int a[]; // �Է¹޴� �迭
	static int check[]; // �湮 check(���ۿ������� �� ��°�� �湮�ϴ� ������)
	static int startVertex[]; // ���� ����

	static int dfs(int i, int cnt, int start) {
		
		if(check[i]!=0) {	//�̹� �湮�ߴ� �������̶��
			if(start!=startVertex[i])	//���� ������ ���� ������ Ȯ��
				return 0;				//�����ʴٸ� 0 ����
			return cnt-check[i];		//������ �� ��° �湮�� �������� ����
		}
		
		check[i]= cnt;	//�� ��° �湮�Ѱ��� ����
		startVertex[i] = start;
		return dfs(a[i], cnt+1, start);	//����Ű�� ����, +1��° �湮, start �״��
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- >0) {
			int n = sc.nextInt();
			a = new int[n+1];
			check = new int[n+1];
			startVertex = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				a[i] = sc.nextInt();
			}
			
			int ans = 0;
			for(int i=1; i<=n; i++) {
				if(check[i]==0)
					ans+=dfs(i,1,i);
			}
			System.out.println(n-ans);
		}
	}
}
