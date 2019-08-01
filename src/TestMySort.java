package com.paixu;

import java.util.Arrays;
import java.util.Random;

public class TestMySort {
    //直接插入排序
    //时间复杂度O(n^2)
    //如果给定的数据是有序的那么时间复杂度就是O(n)
    //直接插入排序---》越有序越快
    //空间复杂度O(1)
    //稳定性：稳定
    public static void insertSort(int[] array) {
        int tmp = 0;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
//  array[j]=array[i]; 这是error的
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    //希尔排序 插入排序的优化
    //时间复杂度：O(n^1.3--n^1.5)
    //空间复杂度：
    //稳定性：不稳定
    public static void shell(int[] array, int gap) {//相当于直接插入排序
        int tmp = 0;
        for (int i = gap; i < array.length; i++) {
            tmp = array[i];
            int j = 0;
            for (j = i - gap; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int[] drr = {5, 3, 1};//对数字分组 给素数
        for (int i = 0; i < drr.length; i++) {
            shell(array, drr[i]);
        }
    }

    //选择排序 效率不是很好
    //时间复杂度：O(n^2)
    //空间复杂度：O(1)
    //稳定性：不稳定
    //判断数据是否有跳跃式的交换--有全是不稳定
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    //堆排序 选择排序的一种
    //时间复杂度：O(nlog2^n)
    //空间复杂度：O(1)
    //稳定性：不稳定
    //adjus:一次调整函数--》负责把每一颗字数调整为大根堆
    public static void adjust(int[] array, int start, int end) {
        int tmp = array[start];
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            if ((i < end) && array[i] < array[i + 1]) {//i<end判断有没有左右子如果有、判断左右子的最大值
                i++;//最大值下标
            }
            if (array[i] > tmp) {
                array[start] = array[i];
                start = i;
            } else if (array[i] < tmp) {
                break;
            }
        }
        array[start] = tmp;
    }

    public static void heapSort(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {//由子推父
            adjust(array, i, array.length - 1);
        }
        //上面代码全部跑完整棵树已经变为大根堆
        for (int j = 0; j < array.length; j++) {
            int tmp = array[0];
            array[0] = array[array.length - 1 - j];
            array[array.length - 1 - j] = tmp;
            //-1 上面已经交换了一次所以要减掉
            adjust(array, 0, array.length - 1 - j - 1);
        }
    }

    //快速排序  递归版本
    //时间复杂度：O(nlog2^n)
    //空间复杂度：O(log2^n)
    //稳定性：不稳定
    public static int partion(int[] array, int low, int high) {//一趟快速排序
        int tmp = array[low];
        while (low < high) {
            while ((low < high) && array[high] >= tmp) {
                high--;
            }
            if (low == high) {
//                array[low]=tmp;
                break;//找到基准了不用走大循环了  直接出
            } else {
                array[low] = array[high];
            }
            while ((low < high) && array[low] <= tmp) {
                low++;
            }
            if (low == high) {
//                array[low]=tmp;
                break;//找到基准了不用走大循环了  直接出
            } else {
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }
    //快排优化
    public static void swap(int[] array,int low,int high){
        int tmp=array[low];
        array[low]=array[high];
        array[high]=tmp;
    }
    //三数取中法  快排第一种优化 大大减少递归次数
    public static  void  takeThreeNumber(int[] array,int low,int high){
        int mid=(low+high)>>>1;
//        array[mid]<=array[low]<=array[high]
        if (array[mid]>array[low]){
            swap(array,mid,low);
        }//array[mid]<=array[low]
        if (array[mid]>array[high]){
            swap(array,mid,high);
        }//array[mid]<=array[high]
        if (array[low]>array[high]){
            swap(array,low,high);
        }//array[low]<=array[high]

    }
    //第二种优化方式 在low和high之间采用直接插入排序
//    public  static  void quickSort(int[] array,int low,int high) {
//        int tmp=array[low];
//        for (int i = low; i <=high ; i++) {
//            for (int j = low-1;  ; j++) {
//
//            }
//        }
//    }
    public static void  quick(int[] array,int low,int high){
        if (low==high){
            return;
        }
        takeThreeNumber(array,low,high);//预防给出的数组是有序的或者low和high之间是有序的
        int par=partion(array,low,high);
        //递归左边--》保证左边有2个数据
        if (par>low+1){
            quick(array,low,par-1);
        }
        //递归右边--》保证右边有2个数据
        if (par<high-1){
            quick(array,par+1,high);
        }
    }
public static void quickSort(int[] array){
        quick(array,0,array.length-1);
}


//快排非递归
    public  static  void quickSort1(int[] array){
        int[] stack=new int[array.length*2];
        int top=0;
        int  low=0;
        int high=array.length-1;
        //先进行一趟快速排序
    int par = partion(array,low,high);
        //判断par左右两边是否是2个或者2个以上数据
        if (par>low+1){
            stack[top++]=low;
            stack[top++]=par-1;
        }
        if (par<high-1){
            stack[top++]=par+1;
            stack[top++]=high;
        }
        //以上代码执行完毕，两边的数对已经全部入栈
        //需要判断栈是否为空如不为空去除两个数对进行partion()
        while (top>0){
            high=stack[--top];
            low=stack[--top];
             par = partion(array,low,high);
            //判断par左右两边是否是2个或者2个以上数据
            if (par>low+1){
                stack[top++]=low;
                stack[top++]=par-1;
            }
            if (par<high-1){
                stack[top++]=par+1;
                stack[top++]=high;
            }
        }
    }

    //归并排序
    //时间复杂度n*log2^n
    //空间复杂度n
    //稳定
    public static void merge(int[] array,int start,int mid,int end){
        int[] tmp=new int[array.length];
        int tmpIndex=start;
        int start2=mid+1;
        int i=start;
        //两个归并段都有数据的时候
        while (start<=mid&&start2<=end){
            if (array[start]<=array[start2]){
                tmp[tmpIndex++]=array[start++];
            }else if (array[start]>=array[start2]){
                tmp[tmpIndex++]=array[start2++];
            }
        }
        while (start<=mid){
            tmp[tmpIndex++]=array[start++];
        }
        while (start2<=end){
            tmp[tmpIndex++]=array[start2++];
        }
        while (i<=end){
            array[i]=tmp[i];
            i++;
        }
    }
    public  static void mergeSort(int[] array,int start,int end){
        if (start>=end){
            return;
        }
        int mid=(start+end)/2;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);//分解
        //肯定是一个一个有序的序列
        //合并的过程
        merge(array,start,mid,end);
    }
    public static void main(String[] args) {
        int[] array = {6, 5, 4, 3, 2, 1};
//      int[] array=new int[10000];
//        Random random=new Random();
//        for (int i = 0; i <array.length ; i++) {
//            array[i]=random.nextInt(10000);
//        }
//        shellSort(array);
//        insertSort(array);
//        selectSort(array);
//        heapSort(array);
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
