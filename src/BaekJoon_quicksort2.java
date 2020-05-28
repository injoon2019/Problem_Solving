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
		swap(array, left, mid);	//중앙 값을 첫 번째 요소로 이동
		
		int pivot = array[left];
		
		int i=left, j=right;
		
		while(i<j) {	//left<right 즉, 교차하기 전까지 반복한다
			while(pivot< array[j]) {	//j는 오른쪽에서 왼쪽으로 피봇보다 작거나 같은 값을 찾는다
				j--;
			}
			
			while(i<j && pivot >= array[i]) {	//i는 왼쪽에서 오른쪽으로 피봇보다 큰 값을 찾는다
				i++;
			}
			swap(array, i, j);	//찾은 i와j를 교환
		}
		//반복문을 벗어난 경우는 i와 j가 만난 경우
		//피봇과 교환 
		array[left] = array[i];
		array[i] = pivot;
		return i;	//구분점이 되는 인덱스를 반환 
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}
	
	public static void quicksort(int[] array, int left, int right) {
		if(left>=right) {	//비교할 요소가 한 개인 경우이므로 메소드 종료
			return;
		}
		
		int pi = partition(array, left, right);	//위의 메소드를 통해서 구한 구분점을 저장
		quicksort(array, left, pi-1);	///left부터 구분점 전까지 다시 한번 재귀호출
		quicksort(array, pi+1, right);	//구분점 다음부터 right까지 다시 한번 재귀호출
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