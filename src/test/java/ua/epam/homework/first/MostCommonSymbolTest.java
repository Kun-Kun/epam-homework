/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.homework.first;

import org.junit.Test;
import ua.epam.homework.first.MostCommonSymbol;

import static org.junit.Assert.*;

/**
 *
 * @author nmcdo5
 */
public class MostCommonSymbolTest {
	
		/**
	 * Test of findMostCommon method, of class MostCommonSymbol.
	 */
	@Test
	public void testFindMostCommon() {
		String text = "abababa ,";
		char expResult = 'a';
		char result = MostCommonSymbol.findMostCommon(text);
		assertEquals(expResult, result);

	}
	
}
