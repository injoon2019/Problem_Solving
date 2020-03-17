//Baekjoon - 10825

import java.io.*;
import java.util.Arrays;

class Student implements Comparable<Student>{
	String name;
	int kor;
	int eng;
	int math;
	
	Student(String name, int kor, int eng, int math){
		this.name= name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	@Override
	public int compareTo(Student that) {
		if(this.kor > that.kor) {
			return -1;
		}else if(this.kor == that.kor) {
			if(this.eng < that.eng) {
				return -1;
			}else if(this.eng==that.eng) {
				if(this.math > that.math) {
					return -1;
				}else if(this.math == that.math) {
					return this.name.compareTo(that.name);
				}
			}
		}
		return 1;
	}
	
}
public class BaekJoon10825 {

	public static void main(String[] args)throws Exception{

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		String[] strToken;
		Student[] sArr = new Student[n];

		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			sArr[i]= new Student(s[0], Integer.parseInt(s[1]),
					Integer.parseInt(s[2]),Integer.parseInt(s[3]));			
		}
		Arrays.sort(sArr);
		for(Student s : sArr) {
			System.out.println(s.name);
		}
	}	
}