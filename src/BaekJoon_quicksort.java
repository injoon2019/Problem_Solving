//Baekjoon - QuickSort
//Quick Sort - https://mygumi.tistory.com/308
//Quick Sort - https://fbtmdwhd33.tistory.com/85
//https://fbtmdwhd33.tistory.com/86
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;



public class BaekJoon_quicksort {
	
	public static void solve() {
		int[] array = {80,70,60,50,40,30,20};
		quicksort(array, 0, array.length-1);
		
		for(int v: array) {
			System.out.println(v);
		}
	}
	
	public static int partition(int[] array, int left, int right) {
		int mid  = (left+right)/2;
		swap(array, left, mid);
		
		int pivot = array[left];
		int i = left, j =right;
		
		while(i<j) {
			while(pivot < array[j]) {
				j--;
			}
			
			while(i<j && pivot >=array[i]) {
				i++;
			}
			swap(array, i , j);
		}
		array[left] = array[i];
		array[i]= pivot;
		return i;
	}

	public static void swap(int[] array, int a, int b) {
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}


	public static void quicksort(int[] array, int left, int right) {
		
		if(left >= right) {
			return;
		}
		
		int pi = partition(array, left, right);
		
		quicksort(array, left, pi-1);
		quicksort(array, pi+1, right);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
}