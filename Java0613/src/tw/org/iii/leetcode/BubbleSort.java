package tw.org.iii.leetcode;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 9, 4, 2, 6, 3, 7, 5 };
		int temp = 0;
		boolean flag = false ; 
        for(int j = 0; j < arr.length -1; j++) {
            for(int i = 0; i < arr.length - 1 - j; i++) {
                //如果當前的數比後一位的數大則交換
                if(arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = true ; 
                }
            }
            if(!flag) {
            	break; 
            } else {
            	flag = false ; 
            }
            System.out.println("第 "+(j+1)+" 輪排序: "+Arrays.toString(arr));
        }
	}

}
