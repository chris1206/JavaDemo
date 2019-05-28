package com.chris.arithmetic;

import org.junit.Test;

/**
 * Created by Chris on 2017/12/28.
 */
public class BubbleSort {

    @Test
    public void test(){
        int[] array = {42, 20, 17, 13, 28, 14, 23, 15};
        BubbleSort1(array);
        for(Integer integer:array){
            System.out.println(integer);
        }
    }

    @Test
    public void bubbleSort() {
        int[] array = {42, 20, 17, 13, 28, 14, 23, 15};
        int temp;
        for (int i = 0; i < array.length-1; i++) {
            for( int j=array.length-1; j>i; j--) {
                if(array[i]>array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for(Integer integer:array){
            System.out.println(integer);
        }
    }

    public void BubbleSort1(int [] arr){

        int temp;//临时变量
        boolean flag;//是否交换的标志
        for(int i=0; i<arr.length-1; i++){   //表示趟数，一共arr.length-1次。

            flag = false;
            for(int j=arr.length-1; j>i; j--){

                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }


}
