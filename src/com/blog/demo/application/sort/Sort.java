package com.blog.demo.application.sort;

import java.util.Arrays;

/*
 * https://blog.csdn.net/chennai1101/article/details/84790200
 */
public class Sort {	
	
	public static void main(String[] args) {
		int num = 10000000;
		int[] array = new int[num];
		
		for (int index = 0; index < num; index++) {
			array[index] = (index + 1);
		}
		
		for (int index = 0; index < num; index++) {
			int swap = (int) (Math.random() * num);
					
			int temp = array[index];
			array[index] = array[swap];
			array[swap] = temp;
		}
		
		long time = System.currentTimeMillis();
//		new Sort().bubbleSort(Arrays.copyOf(array, num));
		
		System.out.println("bubbleSort: " + (System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();
//		new Sort().selectionSort(Arrays.copyOf(array, num));
		
		System.out.println("selectionSort: " + (System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();
//		new Sort().insertionSort(Arrays.copyOf(array, num));
		System.out.println("insertionSort: " + (System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();
		new Sort().mergeSort(Arrays.copyOf(array, num));
		System.out.println("mergeSort: " + (System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();
		new Sort().shellSort(Arrays.copyOf(array, num));
		System.out.println("shellSort: " + (System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();
		new Sort().quickSort1(Arrays.copyOf(array, num));
		System.out.println("quickSort1: " + (System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();
		new Sort().quickSort2(Arrays.copyOf(array, num));
		System.out.println("quickSort2: " + (System.currentTimeMillis() - time));
	}
	
	public void bubbleSort(int[] array) {
//		printArray(array);
		
		for (int end = array.length - 1; end > 1; end--) {
			for (int index = 0; index < end; index++) {
				if (array[index] > array[index + 1]) {
					swap(array, index, index + 1);
				}
			}
		}
//		printArray(array);
	}
	
	public void selectionSort(int[] array) {
		for (int start = 0; start < array.length - 1; start++) {
			int min = start;
			for (int index = start + 1; index < array.length; index++) {
				if (array[min] > array[index]) {
					min = index;
				}
			}
			swap(array, min, start);
		}
	}
	
	public void insertionSort(int[] array) {
		for (int start = 1; start < array.length; start++) {
			int temp = array[start];
			
			int index = start;
			while (index > 0 && array[index - 1] > temp) {
				array[index] = array[index - 1];
				--index;
			}
			array[index] = temp;
		}
	}
	
	public void mergeSort(int[] array) {
		int[] newArray = new int[array.length];
		mergeSort(array, newArray, 0, newArray.length - 1);
//		printArray(array);
	}
	
	public void mergeSort(int[] array, int[] newArray, int start, int end) {
		if (start == end) {
			return;
		} else {
			int mid = (start + end) / 2;
			mergeSort(array, newArray, start, mid);
			mergeSort(array, newArray, mid + 1, end);
			merge(array, newArray, start, mid, end);
		}
	}
	
	public void merge(int[] array, int[] newArray, int start, int mid, int end) {
		int left = start;
		int right = mid + 1;
		int index = start;
		
		while (left <= mid && right <= end) {
			if (array[left] < array[right]) {
				newArray[index++] = array[left++];
			} else {
				newArray[index++] = array[right++];
			}
		}
		
		while (left <= mid) {
			newArray[index++] = array[left++];
		}
		
		if (right <= end) {
			newArray[index++] = array[right++];
		}
		
		for (int i = start; i <= end; i++) {
			array[i] = newArray[i];
		}
		
	}
	
    public void shellSort(int[] array) {
    	int sep = 3;
    	
        int h = 1;
        while (h <= array.length/sep) {
            h = h * sep + 1;
        }
        while (h > 0) {
            for (int start = h; start < array.length; start++) {
                int temp = array[start];
                int index = start;

                while (index >= h && array[index - h] >= temp) {
                    array[index] = array[index - h];
                    index -= h;
                }
                array[index] = temp;
            }
            h = (h - 1) / sep;
        }
//        printArray(array);
    }
    
    public void quickSort1(int[] array) {
    	quickSort1(array, 0, array.length - 1);
//    	printArray(array);
    }
    
    private void quickSort1(int[] array, int start, int end) {    	
    	if (start >= end) {
    		return;
    	} else {
    		int povit = array[end];
    		int partition = partition(array, start, end, povit);
    		quickSort1(array, start, partition - 1);
    		quickSort1(array, partition + 1, end);
    	}
    }
    
    public void quickSort2(int[] array) {
    	quickSort2(array, 0, array.length - 1);
//    	printArray(array);
    }

    private void quickSort2(int[] array, int start, int end) {
    	if (start >= end) {
    		return;
    	} else {
    		int povit = mediaOf3(array, start, end);
    		int partition = partition(array, start, end, povit);
    		quickSort1(array, start, partition - 1);
    		quickSort1(array, partition + 1, end);
    	}
    }
    
    private int mediaOf3(int[] array, int start, int end) {
    	int center = (start + end) / 2;
    	
    	if (array[start] > array[center]) {
    		swap(array, start, center);
    	}
    	
    	if (array[start] > array[end]) {
    		swap(array, start, end);
    	}
    	
    	if (array[center] > array[end]) {
    		swap(array, center, end);
    	}
    	swap(array, center, end - 1);
    	return end - 1;
    }
    
    private int partition(int[] array, int start, int end, int povit) {
    	int left = start;
    	int right = end - 1;
    	
    	while (true) {
    		while (array[left] < povit)
    			++left;
    		
    		while (right >= start && array[right] > povit)
    			--right;
    		
    		if (left < right) {
    			swap(array, left, right);
    		} else {
    			break;
    		}
    	}
    	swap(array, left, end);
    	return left;
    }
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private static void printArray(int[] array) {
		for (int value : array) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
	
}
