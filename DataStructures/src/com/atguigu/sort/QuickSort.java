package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 快速排序；
 * 从小到大排序：
 * 1、第一轮以中间值为基准，分成左右两部分，左右分别向中间扫描，将左边大于等于基准值的数 与 右边小于等于基准值的数互换
 * 如果过程中将基准值换到了左边，说明左边已经扫描到尽头，右边可以继续往前扫描；同理如果将基准值换到了右边，说明右边已经扫描到尽头，左边继续往前扫描
 * 直到左右都到达基准值，说明此时基准值左右已经分清。
 *
 * 2、将左右分开进行递归操作，同样找个基准值，将小的放左边，大的放右边，按上述1方法去递归即可
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		//int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};
		
		//测试快排的执行速度
		// 创建要给80000个的随机的数组
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}
		
		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);
		
		quickSort(arr, 0, arr.length-1);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);
		//System.out.println("arr=" + Arrays.toString(arr));
	}

	public static void quickSort(int[] arr,int left, int right) {
		int l = left; //左游标
		int r = right; //右游标
		//pivot 中轴值
		int pivot = arr[(left + right) / 2];
		int temp = 0; //临时变量，作为交换时使用
		//while循环的目的是让比pivot 值小放到左边
		//比pivot 值大放到右边
		while( l < r) { 
			//在pivot的左边一直找,找到大于等于pivot值,才退出
			while( arr[l] < pivot) {
				l += 1;
			}
			//在pivot的右边一直找,找到小于等于pivot值,才退出
			while(arr[r] > pivot) {
				r -= 1;
			}
			//如果l >= r说明游标都已经到pivot的位置，pivot 的左右两的值，已经按照左边全部是
			//小于等于pivot值，右边全部是大于等于pivot值排列
			if( l >= r) {
				break;
			}
			
			//交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			//如果交换完后，发现这个arr[l] == pivot值 相等，说明此时l左边已经没有比pivot大的值，r右边也没有比pivot小的值，l已经不能动，但r可以前移一步继续判断
			if(arr[l] == pivot) {
				r -= 1;
			}
			//如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
			if(arr[r] == pivot) {
				l += 1;
			}
		}
		
		// 如果 l == r, 必须l++, r--, 否则为出现栈溢出。
		// l==r也说明第一轮pivot左右都已经分清，可以调整l\r进行递归
		if (l == r) {
			l += 1;
			r -= 1;
		}
		//向左递归
		if(left < r) {
			quickSort(arr, left, r);
		}
		//向右递归
		if(right > l) {
			quickSort(arr, l, right);
		}
		
		
	}
}
