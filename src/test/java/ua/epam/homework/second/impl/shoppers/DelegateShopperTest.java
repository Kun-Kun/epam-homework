/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.homework.second.impl.shoppers;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import ua.epam.homework.second.api.Shopper;
import ua.epam.homework.second.data.ShoppingResult;

/**
 *
 * @author nmcdo5
 */
public class DelegateShopperTest {
	
	public DelegateShopperTest() {
	}

	/**
	 * Test of buyGoods method, of class DelegateShopper.
	 */
	@Test
	public void testBuyGoods() {
		DelegateShopper shopper = new DelegateShopper(new Shopper() {
			@Override
			public ShoppingResult buyGoods(List<String> toBuyList) {
				ShoppingResult result = new ShoppingResult();
				result.setTotalPrice(555f);
				return result;
			}
		});
		ShoppingResult result = shopper.buyGoods(new ArrayList<>());
		assertEquals(555f, result.getTotalPrice(),0.001f);
	}
	
}
