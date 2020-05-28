//Baekjoon - QuickSort
//Quick Sort - https://mygumi.tistory.com/308
//Quick Sort - https://fbtmdwhd33.tistory.com/85
//https://fbtmdwhd33.tistory.com/86
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.*;


public class BaekJoon_quicksort2 {
	
	public static int partition(int[] array, int left, int right) {
		int mid = (left+right)/2;
		swap(array, left, mid);	//�߾� ���� ù ��° ��ҷ� �̵�
		
		int pivot = array[left];
		
		int i=left, j=right;
		
		while(i<j) {	//left<right ��, �����ϱ� ������ �ݺ��Ѵ�
			while(pivot< array[j]) {	//j�� �����ʿ��� �������� �Ǻ����� �۰ų� ���� ���� ã�´�
				j--;
			}
			
			while(i<j && pivot >= array[i]) {	//i�� ���ʿ��� ���������� �Ǻ����� ū ���� ã�´�
				i++;
			}
			swap(array, i, j);	//ã�� i��j�� ��ȯ
		}
		//�ݺ����� ��� ���� i�� j�� ���� ���
		//�Ǻ��� ��ȯ 
		array[left] = array[i];
		array[i] = pivot;
		return i;	//�������� �Ǵ� �ε����� ��ȯ 
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}
	
	public static void quicksort(int[] array, int left, int right) {
		if(left>=right) {	//���� ��Ұ� �� ���� ����̹Ƿ� �޼ҵ� ����
			return;
		}
		
		int pi = partition(array, left, right);	//���� �޼ҵ带 ���ؼ� ���� �������� ����
		quicksort(array, left, pi-1);	///left���� ������ ������ �ٽ� �ѹ� ���ȣ��
		quicksort(array, pi+1, right);	//������ �������� right���� �ٽ� �ѹ� ���ȣ��
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		quicksort(arr, 0, n-1);
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	}
}