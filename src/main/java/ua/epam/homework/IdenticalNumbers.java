package ua.epam.homework;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class IdenticalNumbers {
	
	public static int[] findIdenticalNumbers(int[] array1, int[] array2){
		int[] intersection = new int[array2.length];
		int[] sortedArray1 = Arrays.copyOf(array1,array1.length);
		int[] sortedArray2 = Arrays.copyOf(array2,array2.length);
		Arrays.sort(sortedArray1);
		Arrays.sort(sortedArray2);
		int i = 0;
		int	a1=0,a2=0;
		while (a1<array1.length&&a2<array2.length) {
			if (sortedArray1[a1] == sortedArray2[a2]) {
				intersection[i] = sortedArray1[a1];
				i++;
				a1++;
				a2++;
			} else if (sortedArray1[a1] < sortedArray2[a2]) {
				a1++;
			} else {
				a2++;
			}
		}
		return Arrays.copyOf(intersection,i);
	}

	public static void main(String[] args) {

		int[] array1 = {14, 6, 8, 16, 7, 18, 13, 17, 19, 13};
		int[] array2 = {7, 15, 2, 0, 13, 8, 15, 1, 6, 19};
		sout(array1);
		System.out.println();
		sout(array2);
		System.out.println();
		Date start = new Date();
		int[] inter = IdenticalNumbers.findIdenticalNumbers(array1,array2);
		Date end = new Date();
		sout(inter);
		System.out.println(end.getTime()-start.getTime());

	}

	public static void fill(int[] array){
		Random random = new Random();
		for (int i = 0; i <array.length ; i++) {
			array[i]=random.nextInt(20);
		}
	}
	public static void sout(int[] array){
		for (int i = 0; i <array.length ; i++) {
			System.out.print(array[i]+", ");
		}
	}
}
