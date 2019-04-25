package ua.epam.homework;

import java.util.Arrays;

public class PositiveNumbers {
	public static int getMaxAvgPositiveNumber(int[][] array){
		float maxAvg = -1;
		int maxAvgPosition = -1;
		for (int i = array.length-1; i >= 0 ; i--) {
			int sum =0;
			int count = 0;
			float avg = -1f;
			for (int value : array[i]){
				if(value>=0){
					sum+=value;
					count++;
				}
				if(count>0) {
					avg = (float) sum / count;
				}
			}
			if (avg>maxAvg){
				maxAvg = avg;
				maxAvgPosition = i;
			}
		}
		return maxAvgPosition;
		
	}
	
	public static int getMaxAvgPositiveNumberAlt(int[][] array){
		int[][] filtredArray = filterPositive(array,false);
		float maxAvg = -1;
		int maxAvgPosition = -1;
		for (int i = filtredArray.length-1; i >= 0 ; i--) {
			int sum =0;
			float avg = -1f;
			int[] row = filtredArray[i];
			for (int j = 0; j < row.length; j++) {
				sum+=row[j];
			}
			avg = (float) sum / row.length;
			if (avg>maxAvg){
				maxAvg = avg;
				maxAvgPosition = i;
			}
		}
		return maxAvgPosition;
		
	}
	
	public static int[][] copyArray(int[][]matrix){
		return Arrays.stream(matrix).map(r -> r.clone()).toArray(int[][]::new);
	} 
	
	public static int[][] filterPositive(int[][] array, boolean collapseEmptyRows){
		int[][] copiedArray = copyArray(array);
		int writeRowPosition=0;
		for (int i = 0; i<copiedArray.length ; i++) {
			int[] row = copiedArray[i];
			int writePos = 0;
			for (int readPos = 0; readPos < row.length; readPos++) {
				if(row[readPos]>=0){
					row[writePos] = row[readPos];
					writePos++;
				}
			}
			copiedArray[writeRowPosition] = Arrays.copyOf(row, writePos);
			if(!collapseEmptyRows||writePos>0){
				writeRowPosition++;
			}
		}
		copiedArray=Arrays.copyOf(copiedArray, writeRowPosition);
		return copiedArray;
	}

	public static void main(String[] args) {
		int[][] array = {{-14, 6, 8, -16, 7, -18, 1, -17, -19, 13},{7, 15, 2, 0, 13, 8, 15, 1, 6, 19},{-4,-8,-9,-3},{7, -15, -2, 0, 13, -8, 15, -1, 6, -19}};
		for(int[] row : filterPositive(array,false)){
			IdenticalNumbers.sout(row);
			System.out.println("");
		}
		System.out.println(getMaxAvgPositiveNumberAlt(array));
		System.out.println(getMaxAvgPositiveNumber(array));
		
	}
}
