package ua.epam.homework.second.impl;

import ua.epam.homework.second.api.Buyable;
import ua.epam.homework.second.api.Shopper;
import ua.epam.homework.second.data.ShoppingResult;
import ua.epam.homework.second.impl.shoppers.DelegateShopper;

import java.util.List;


public class Wife extends DelegateShopper {
	public Wife(Shopper shopper) {
		super(shopper);
	}

	public void printShoppingResult(ShoppingResult result){
		System.out.println("Total list:");
		for (Buyable goods : result.getAllProductList()){
			System.out.println(goods);
		}
		System.out.println("");
		System.out.println("Bought:");

		for (Buyable goods : result.getPurchasedProductList()){
			System.out.println(goods);
		}

		System.out.printf("Total price = %.2f",result.getTotalPrice());
	}

	public void doShopping(List<String> toBuyList){
		ShoppingResult shoppingResult = buyGoods(toBuyList);
		printShoppingResult(shoppingResult);
	}


}
