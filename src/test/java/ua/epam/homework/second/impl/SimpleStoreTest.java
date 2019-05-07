/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.homework.second.impl;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ua.epam.homework.second.api.Buyable;
import ua.epam.homework.second.data.Goods;

/**
 *
 * @author nmcdo5
 */
public class SimpleStoreTest {
	
	public SimpleStoreTest() {
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
	 * Test of putProduct method, of class SimpleStore.
	 */
	@Test
	public void testPutProduct() {
		Buyable product = new Goods("Test", 10f);
		SimpleStore instance = new SimpleStore();
		instance.putProduct(product);
		assertEquals(1, instance.getOriginalProductList().size());
		assertEquals(product, instance.getOriginalProductList().get(0));
	}

	/**
	 * Test of removeProduct method, of class SimpleStore.
	 */
	@Test
	public void testRemoveProduct() {
		Buyable product = new Goods("Test", 10f);
		SimpleStore instance = new SimpleStore();
		instance.putProduct(product);
		assertEquals(1, instance.getOriginalProductList().size());
		instance.removeProduct(product);
		assertEquals(0, instance.getOriginalProductList().size());
	}
	
	@Test
	public void testRemoveProductFromEmptyShop() {
		Buyable product = new Goods("Test", 10f);
		SimpleStore instance = new SimpleStore();
		assertEquals(0, instance.getOriginalProductList().size());
		instance.removeProduct(product);
		assertEquals(0, instance.getOriginalProductList().size());

	}

	/**
	 * Test of getOriginalProductList method, of class SimpleStore.
	 */
	@Test
	public void testGetOriginalProductList() {
		SimpleStore instance = new SimpleStore();
		List<Buyable> expResult = instance.getOriginalProductList();
		List<Buyable> result = instance.getOriginalProductList();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getAllProductsList method, of class SimpleStore.
	 */
	@Test
	public void testGetAllProductsList() {
		SimpleStore instance = new SimpleStore();
		List<Buyable> expBadResult = instance.getOriginalProductList();
		List<Buyable> expResult = instance.getAllProductsList();
		List<Buyable> result = instance.getAllProductsList();
		assertNotSame(expBadResult, result);
		assertNotSame(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of orderProducts method, of class SimpleStore.
	 */
	@Test
	public void testOrderProducts() {
		List<String> wanted = new ArrayList();
		wanted.add("Test");
		wanted.add("Test3");
		wanted.add("TestNo");
		wanted.add("TestNo1");
		SimpleStore instance = new SimpleStore();
		Buyable product1 = new Goods("Test", 10f);
		Buyable product2 = new Goods("Test1", 11f);
		Buyable product3 = new Goods("Test2", 12f);
		Buyable product4 = new Goods("Test3", 13f);
		instance.putProduct(product1);
		instance.putProduct(product2);
		instance.putProduct(product3);
		instance.putProduct(product4);
		List<Buyable> expResult = new ArrayList<>();
		expResult.add(product1);
		expResult.add(product4);
		List<Buyable> result = instance.orderProducts(wanted);
		assertEquals(expResult, result);
	}

	
	/**
	 * Test of orderProducts method, of class SimpleStore.
	 */
	@Test
	public void testOrderProductsEmptyOrderList() {
		List<String> wanted = new ArrayList();
		SimpleStore instance = new SimpleStore();
		Buyable product1 = new Goods("Test", 10f);
		Buyable product2 = new Goods("Test1", 11f);
		Buyable product3 = new Goods("Test2", 12f);
		Buyable product4 = new Goods("Test3", 13f);
		instance.putProduct(product1);
		instance.putProduct(product2);
		instance.putProduct(product3);
		instance.putProduct(product4);
		List<Buyable> expResult = new ArrayList<>();
		List<Buyable> result = instance.orderProducts(wanted);
		assertEquals(expResult, result);
	}
	
		/**
	 * Test of orderProducts method, of class SimpleStore.
	 */
	@Test
	public void testOrderProductsEmptyShop() {
		List<String> wanted = new ArrayList();
		wanted.add("Test");
		wanted.add("Test3");
		wanted.add("TestNo");
		wanted.add("TestNo1");
		SimpleStore instance = new SimpleStore();
		List<Buyable> expResult = new ArrayList<>();
		List<Buyable> result = instance.orderProducts(wanted);
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of orderProducts method, of class SimpleStore.
	 */
	@Test
	public void testOrderProductsNullProduct() {
		List<String> wanted = new ArrayList();
		wanted.add("Test");
		wanted.add("Test3");
		wanted.add("TestNo");
		wanted.add("TestNo1");
		SimpleStore instance = new SimpleStore();
		instance.putProduct(null);
		List<Buyable> expResult = new ArrayList<>();
		List<Buyable> result = instance.orderProducts(wanted);
		assertEquals(expResult, result);
	}
	
		/**
	 * Test of orderProducts method, of class SimpleStore.
	 */
	@Test
	public void testOrderProductsNullList() {
		List<String> wanted = new ArrayList();
		wanted.add("Test");
		wanted.add(null);
		SimpleStore instance = new SimpleStore();
		Buyable product1 = new Goods("Test", 10f);
		instance.putProduct(product1);
		List<Buyable> expResult = new ArrayList<>();
		expResult.add(product1);
		List<Buyable> result = instance.orderProducts(wanted);
		assertEquals(expResult, result);
	}
}
