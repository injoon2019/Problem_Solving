//Kakao Summer Internship 2020 _1
import java.io.*;
import java.util.*;
public class Kakao_SummerInternship2020_1 {
	
	public static void main(String[] args)throws Exception{
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		String ans = solution(numbers, hand);
		System.out.println(ans);
	}
	
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        boolean rightUser = false;
        if(hand.equals("right")){
            rightUser = true;
        }
        int[] leftArr = {1,4,7};
        int[] rightArr = {3,6,9};
        int[] midArr = {2,5,8,0};
        Spot leftIndex = new Spot(3,0);  //*에 있다고 가정하면 인덱스가 1,4,7,*중 3이다
        Spot rightIndex = new Spot(3,2);
        
        for(int i=0; i<numbers.length; i++){
//        	System.out.println("leftIndex"+leftIndex.y +" "+ leftIndex.x);
//        	System.out.println("rightIndex"+rightIndex.y +" "+ rightIndex.x);
            if(numbers[i]==1 ||numbers[i]==4||numbers[i]==7 ){ //left쪽이다
                sb.append('L');
                leftIndex.y = numbers[i]/3;
                leftIndex.x = 0;
            }else if (numbers[i]==3 ||numbers[i]==6 ||numbers[i]==9){    //right쪽이다
                sb.append('R');
                rightIndex.y = numbers[i]/4;
                rightIndex.x = 2;
            }else {
                //거리가 다른 경우
                int newY = numbers[i]/3;
                if(numbers[i]==0){
                    newY = 3;
                }
                Spot newSpot = new Spot(newY, 1);
                int leftDistance = Math.abs(newSpot.y - leftIndex.y) + Math.abs(newSpot.x - leftIndex.x);
                int rightDistance = Math.abs(newSpot.y - rightIndex.y) + Math.abs(newSpot.x - rightIndex.x);
                
                if(i==8) {
                	System.out.println("leftIndex"+leftIndex.y +" "+ leftIndex.x);
                	System.out.println("rightIndex"+rightIndex.y +" "+ rightIndex.x);
                    System.out.println("leftDistance"+leftDistance);
                    System.out.println("rightDistance"+rightDistance);
                    System.out.println("------------");
                }
                
                if(leftDistance< rightDistance){
                    sb.append('L');
                    leftIndex.y = newSpot.y;
                    leftIndex.x = newSpot.x;
                }else if (leftDistance > rightDistance){
                    sb.append('R');
                    rightIndex.y = newSpot.y;
                    rightIndex.x = newSpot.x;
                }else{//거리가 같은 경우
                	System.out.println("check");
                    if(rightUser){
                    	System.out.println("check");
                        sb.append('R');
                        rightIndex.y = newSpot.y;
                        rightIndex.x = newSpot.x;
                    }else{
                    	System.out.println("check2");
                        sb.append('L');
                        leftIndex.y = newSpot.y;
                        leftIndex.x = newSpot.x;
                    }
                }
                
            }
        }
        String answer = sb.toString();
        return answer;
    }
    
    public static class Spot{
        int y, x;
        public Spot(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
