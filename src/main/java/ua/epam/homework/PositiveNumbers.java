package ua.epam.homework;

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

	public static void main(String[] args) {
		int[][] array = {{-14, 6, 8, -16, 7, -18, 1, -17, -19, 13},{7, 15, 2, 0, 13, 8, 15, 1, 6, 19}};
		System.out.println(PositiveNumbers.getMaxAvgPositiveNumber(array));
	}
}
