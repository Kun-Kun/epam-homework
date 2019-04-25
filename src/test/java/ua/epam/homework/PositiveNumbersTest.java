package ua.epam.homework;

import org.junit.Assert;
import org.junit.Test;



public class PositiveNumbersTest {

	@Test
	public void getMaxAvgPositiveNumberEmpty() throws Exception {
		int[][] input = {};
		int expected = -1 ;
		int result = PositiveNumbers.getMaxAvgPositiveNumber(input);
		Assert.assertEquals(expected,result);
	}

	@Test
	public void getMaxAvgPositiveNumber() throws Exception {
		int[][] input = {{-14, 6, 8, -16, 7, -18, 1, -17, -19, 13},{7, 15, 2, 0, 13, 8, 15, 1, 6, 19},{-4,-8,-9,-3},{7, -15, -2, 0, 13, -8, 15, -1, 6, -19}};
		int expected = 1 ;
		int result = PositiveNumbers.getMaxAvgPositiveNumber(input);
		Assert.assertEquals(expected,result);
	}

	@Test
	public void getMaxAvgPositiveNumberNoPositive() throws Exception {
		int[][] input = {{-1,-5},{-2,-7}};
		int expected = -1 ;
		int result = PositiveNumbers.getMaxAvgPositiveNumber(input);
		Assert.assertEquals(expected,result);
	}
	@Test
	public void getMaxAvgPositiveNumberAltEmpty() throws Exception {
		int[][] input = {};
		int expected = -1 ;
		int result = PositiveNumbers.getMaxAvgPositiveNumberAlt(input);
		Assert.assertEquals(expected,result);
	}
	@Test
	public void getMaxAvgPositiveNumberAlt() throws Exception {
		int[][] input = {{-14, 6, 8, -16, 7, -18, 1, -17, -19, 13},{7, 15, 2, 0, 13, 8, 15, 1, 6, 19},{-4,-8,-9,-3},{7, -15, -2, 0, 13, -8, 15, -1, 6, -19}};
		int expected = 1 ;
		int result = PositiveNumbers.getMaxAvgPositiveNumberAlt(input);
		Assert.assertEquals(expected,result);
	}

	@Test
	public void getMaxAvgPositiveNumberAltNoPositive() throws Exception {
		int[][] input = {{-1,-5},{-2,-7}};
		int expected = -1 ;
		int result = PositiveNumbers.getMaxAvgPositiveNumberAlt(input);
		Assert.assertEquals(expected,result);
	}

	@Test
	public void copyArray() throws Exception {
		int[][] input = {{-1,0},{1,2}};
		int[][] output = PositiveNumbers.copyArray(input);
		Assert.assertArrayEquals(input,output);
		Assert.assertNotSame(input,output);
		Assert.assertNotSame(input[0],output[0]);
	}

	@Test
	public void filterPositive() throws Exception {
		int[][] input = {{-14, 6, 8, -16, 7, -18, 1, -17, -19, 13},{7, 15, 2, 0, 13, 8, 15, 1, 6, 19},{-4,-8,-9,-3},{7, -15, -2, 0, 13, -8, 15, -1, 6, -19}};
		int[][] expected = {{6, 8, 7, 1, 13},{7, 15, 2, 0, 13, 8, 15, 1, 6, 19},{},{7, 0, 13, 15, 6}} ;
		int[][] result = PositiveNumbers.filterPositive(input,false);
		Assert.assertArrayEquals(expected,result);
	}

	@Test
	public void filterPositiveColapse() throws Exception {
		int[][] input = {{-14, 6, 8, -16, 7, -18, 1, -17, -19, 13},{7, 15, 2, 0, 13, 8, 15, 1, 6, 19},{-4,-8,-9,-3},{7, -15, -2, 0, 13, -8, 15, -1, 6, -19}};
		int[][] expected = {{6, 8, 7, 1, 13},{7, 15, 2, 0, 13, 8, 15, 1, 6, 19},{7, 0, 13, 15, 6}} ;
		int[][] result = PositiveNumbers.filterPositive(input,true);
		Assert.assertArrayEquals(expected,result);
	}

}