/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.homework.second.impl.shoppers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ua.epam.homework.second.api.ShopForUser;
import ua.epam.homework.second.data.ShoppingResult;
import ua.epam.homework.second.impl.SimpleStore;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;
import ua.epam.homework.second.data.Goods;

/**
 *
 * @author nmcdo5
 */
public class ShopWalkerShopperTest {
	
	public ShopWalkerShopperTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of setKnownShops method, of class ShopWalkerShopper.
	 */
	@Test
	public void testSetKnownShops() {
		Set<ShopForUser> knownShops = new HashSet<>();
		knownShops.add(new SimpleStore());
		ShopWalkerShopper instance = new ShopWalkerShopper();
		instance.setKnownShops(knownShops);
		assertEquals(knownShops, instance.getKnownShops());
	}

	/**
	 * Test of memorizeShop method, of class ShopWalkerShopper.
	 */
	@Test
	public void testMemorizeShop() {
		SimpleStore shop = new SimpleStore();
		SimpleStore shop1 = new SimpleStore();
		shop1.putProduct(new Goods("test", 10f));
		ShopWalkerShopper instance = new ShopWalkerShopper();
		instance.memorizeShop(shop);
		instance.memorizeShop(shop1);
		assertThat(instance.getKnownShops(), contains(shop,shop1));
	}

	/**
	 * Test of buyGoods method, of class ShopWalkerShopper.
	 */
	@Test
	public void testBuyGoods() {
		List<String> toBuyList = new ArrayList();
		toBuyList.add("Sony");
		toBuyList.add("Bread");
		toBuyList.add("Vodka");
		toBuyList.add("Coco");
		
		ShopWalkerShopper instance = new ShopWalkerShopper();
		
		SimpleStore groceryStore = new SimpleStore();
		groceryStore.putProduct(new Goods("Bread",110f));
		groceryStore.putProduct(new Goods("Sausage",80f));

		SimpleStore applianceShop = new SimpleStore();
		applianceShop.putProduct(new Goods("Sony",100f));
		applianceShop.putProduct(new Goods("Samsung",80f));
		
		instance.memorizeShop(groceryStore);
		instance.memorizeShop(applianceShop);
		
		ShoppingResult result = instance.buyGoods(toBuyList);
		
		assertEquals(210f, result.getTotalPrice(),0.001);
		assertThat(result.getAllProductList(), hasItems(new Goods("Bread",110f),new Goods("Sausage",80f),new Goods("Sony",100f),new Goods("Samsung",80f)));
		assertThat(result.getPurchasedProductList(), hasItems(new Goods("Bread",110f),new Goods("Sony",100f)));

		
	}
	
}
