//Baekjoon - 1676
//https://ksj14.tistory.com/entry/BackJoon1676-%ED%8C%A9%ED%86%A0%EB%A6%AC%EC%96%BC-0%EC%9D%98-%EA%B0%9C%EC%88%98
/*
 * 0�� ����� ���ؼ��� 2�� 5�� �ʿ��ϴ�. 5�� 2���� �ξ� ���� ��Ÿ���� ��������� 5�� ��� ��Ÿ������ �����̴�.
 * �����ؾ��� ���� 25 ���� ���� 5�� �ι� ��Ÿ�� ����̴�.
 * ���� n�� ������ 500���� �̹Ƿ� 
 * 5�� �ѹ� ������ 5�� ��� ��Ÿ������, 25�� ������ 25�� ��� ��Ÿ������.. ī�����ϸ�ȴ�. 
 * */
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class BaekJoon1676 {


	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int ans = n / 5 + n / 25 + n / 125;

		System.out.println(ans);
	}	
}