//Baekjoon - 11576

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
public class BaekJoon11576 {

	
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken= br.readLine().split(" ");
		int A= Integer.parseInt(strToken[0]);
		int B= Integer.parseInt(strToken[1]);
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int m = Integer.parseInt(br.readLine());
		int sum = 0;
		strToken = br.readLine().split(" ");
		//10 �������� ��ȯ Pow �Լ��� ���� �ʴ� ���
		for(int i=0; i<m; i++) {
			sum = sum*A + Integer.parseInt(strToken[i]);
		}
		
		//B�������� ��ȯ
		while(sum !=0) {
			stack.push(sum%B);
			sum /= B;
		}
		
		//Stack�� ����ϴ� ������, StringBuilder�� ���� 2�ڸ� ���� ��� reverse�� ���ָ� 
		//�յڰ� �ٲ������� ������ ������ �߻��� �� �ֱ� �����̴�
		int size = stack.size();
		for(int i=0; i<size; i++) {
			if(i== size-1)
				System.out.print(stack.pop());
			else
				System.out.print(stack.pop()+" ");
		}
	}	
}