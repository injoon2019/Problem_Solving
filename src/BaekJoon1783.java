//Baekjoon - 1783
import java.io.*;
import java.util.*;

public class BaekJoon1783 {
	 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] strToken = br.readLine().split(" ");
        int N = Integer.parseInt(strToken[0]);
        int M = Integer.parseInt(strToken[1]);
        
        if(N==1)	//���� ��ĭ�̸� ������ �� ����
        	System.out.println("1");
        else if (N==2)	//���ΰ� �� ĭ�̸� 2�� 3���� ���� (3ȸ������ ������ �� ����)
        	System.out.println(Math.min(4, (M+1)/2));
        //1,2,3,4���� ��� �ѹ����� ���;� �Ѵ�
        else if (N>=3) {
        	//���ΰ� 6������ �ִ� 4ĭ (1,4,2,3)
        	if(M<=6)
        		System.out.println(Math.min(4, M));
        	else	//2�� 3�� �ѹ��� �������� 1,2��
        		System.out.println(M-2);
        		
        }
    }
}
