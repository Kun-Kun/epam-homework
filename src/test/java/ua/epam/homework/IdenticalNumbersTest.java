/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.homework;

import org.junit.Test;
import ua.epam.homework.first.IdenticalNumbers;

import static org.junit.Assert.*;

/**
 *
 * @author nmcdo5
 */
public class IdenticalNumbersTest {
	
	/**
	 * Test of findIdenticalNumbers method, of class IdenticalNumbers.
	 */
	@Test
	public void testFindIdenticalNumbers() {
		int[] array1 = {8,5,3,9,-1,-3,9};
		int[] array2 = {6,4,3,9,7,9,-1,-3};
		int[] expResult = {-3,-1,3,9,9};
		int[] result = IdenticalNumbers.findIdenticalNumbers(array1, array2);
		assertArrayEquals(expResult, result);
	}

	@Test
	public void testFindIdenticalNumbersEmptySecondArray() {
		int[] array1 = {8,5,3,9,-1,-3,9};
		int[] array2 = {};
		int[] expResult = {};
		int[] result = IdenticalNumbers.findIdenticalNumbers(array1, array2);
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public void testFindIdenticalNumbersEmptyFirstArray() {
		int[] array2 = {8,5,3,9,-1,-3,9};
		int[] array1 = {};
		int[] expResult = {};
		int[] result = IdenticalNumbers.findIdenticalNumbers(array1, array2);
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public void testFindIdenticalNumbersNoIdentical() {
		int[] array2 = {8,5,3,9,-1,-3,9};
		int[] array1 = {7,6,4,2,1,0,-2};
		int[] expResult = {};
		int[] result = IdenticalNumbers.findIdenticalNumbers(array1, array2);
		assertArrayEquals(expResult, result);
	}
	

	
}
