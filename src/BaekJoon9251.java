//Baekjoon - 9251 (LCS-Longest Common Subsequence)
import java.io.*;
import java.util.*;

public class BaekJoon9251 {
	static String a, b;
	static int dp[][];
	
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		a = sc.nextLine();
		b= sc.nextLine();
		
		//������ �������� ������ �������� ���� �� ������� �ؾ��Ѵ�
		dp = new int[b.length()+1][a.length()+1];	//�� ���ڿ��� ���̸�ŭ ����
		
		
		for(int i=1; i<=b.length(); i++) {	//b�� ��������
			for(int j=1; j<=a.length(); j++) {	//a�� ��
				if(b.charAt(i-1) != a.charAt(j-1)) { //�ٸ� ���
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);	//��ȭ��
				}else {
					dp[i][j] =dp[i-1][j-1]+1;	//��ȭ��
				}
			}
		}
		
		System.out.println(dp[b.length()][a.length()]);
	}	
	
}