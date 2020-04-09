//Baekjoon - 1654 ���� �ڸ���
import java.io.*;
import java.util.*;

public class BaekJoon1654 {
	
	public static void main(String[] args) throws Exception {		
		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();	//�̹� ������ �ִ� ������ ����
		int N = scan.nextInt();	//�ʿ��� ������ ���� 
		long[] arr = new long[K];
		for(int i=0;  i<K; i++) {
			arr[i]= scan.nextInt();
		}
		Arrays.parallelSort(arr);
		long max = arr[K-1];	//mid�� ���ϴ� �������� min�� max�� ���ϸ� ��� int ������ ���� �� ����
		long min = 1;	//�������� ���� ���̴� �ڿ����� �����Ƿ� 0���� �ʱ�ȭ�ϸ� ���� �߻�
		long mid = 0;
		long count = 0;
		while(min<=max) {
			mid = (max+min)/2;
			count=0;
			for(int i=0; i<K;i++) {
				count += arr[i]/mid;
			}
			
			if(count >=N) {	//ó������ ==�̵Ǹ� break�� �ɾ��µ�, �װ� ��ü���� ���� ã�� ���� ����������
				min = mid+1;	//����ó�� ������ ����� �� �߿��� �ִ밪�� ���� ��쿡�� �ε�ȣ ó���� �ؾ��Ѵ�
			}					//==�� �ƴϴ��� ���� �Ǵ� ��찡 �����Ѵ�
			else if(count<N){
				max = mid-1;
			}
		}
		System.out.println(max);	//�� mid�� �ƴ� max�� ���ϱ�?
	}
}



