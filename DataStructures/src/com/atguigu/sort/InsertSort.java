package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 * 	1、从小到大排序逻辑：第一个数不管，后面的每一个数与前面所有数依次进行比较（从当前位置-1开始往前比较），
 *      比其大的数往后移，直到找到合适位置
 *  2、从大到小同理
 */
public class InsertSort {

	public static void main(String[] args) {
		//int[] arr = {101, 34, 119, 1, -1, 89}; 
		// 创建要给80000个的随机的数组
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}

		System.out.println("插入排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);
		
		insertSort(arr); //调用插入排序算法
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);
		
		//System.out.println(Arrays.toString(arr));
		
		
		
		
	}
	
	//插入排序
	public static void insertSort(int[] arr) {
		int insertVal = 0;
		int insertIndex = 0;
		//使用for循环来把代码简化
		for(int i = 1; i < arr.length; i++) {
			//定义待插入的数
			insertVal = arr[i];
			//定义待插入的位置，首先假设插入到自己前一位
			insertIndex = i - 1; // 即arr[1]的前面这个数的下标
	
			// 给insertVal 找到插入的位置
			// 说明
			// 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
			// 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
			// 3. 就需要将 arr[insertIndex] 后移
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
				insertIndex--;
			}
			// 当退出while循环时，说明插入的位置找到, insertIndex + 1
			// 举例：理解不了，我们一会 debug
			//这里我们判断是否需要赋值
			if(insertIndex + 1 != i) {  //条件不成立就说明进入过while循环，将比较大的数往后移动过
				arr[insertIndex + 1] = insertVal;
			}
	
			//System.out.println("第"+i+"轮插入");
			//System.out.println(Arrays.toString(arr));
		}
		
		
		/*
		
		
		//使用逐步推导的方式来讲解，便利理解
		//第1轮 {101, 34, 119, 1};  => {34, 101, 119, 1}
		
		
		//{101, 34, 119, 1}; => {101,101,119,1}
		//定义待插入的数
		int insertVal = arr[1];
		int insertIndex = 1 - 1; //arr[1]的前面这个数的下标，与前一个数据进行比较
		
		//给insertVal 找到插入的位置
		//说明
		//1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
		//2. insertVal < arr[insertIndex] 待插入的数，说明这个数需要往前插入
		//3. 就需要先将 arr[insertIndex] 后移
		//4. 这个while循环就是指当前代插入数前面有n个数，依次跟前一个数进行比较，直到找到合适位置的前一个位置，退出循环
		while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}
		//当退出while循环时，说明插入的位置前一个位置找到, insertIndex + 1
		//举例：理解不了，我们一会 debug
		arr[insertIndex + 1] = insertVal;
		
		System.out.println("第1轮插入");
		System.out.println(Arrays.toString(arr));
		
		//第2轮
		insertVal = arr[2];
		insertIndex = 2 - 1; 
		
		while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}
		
		arr[insertIndex + 1] = insertVal;
		System.out.println("第2轮插入");
		System.out.println(Arrays.toString(arr));
		
		
		//第3轮
		insertVal = arr[3];
		insertIndex = 3 - 1;

		while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}

		arr[insertIndex + 1] = insertVal;
		System.out.println("第3轮插入");
		System.out.println(Arrays.toString(arr)); */
		
	}

}
