package ua.epam.homework.second.impl.shoppers;

import ua.epam.homework.second.api.Shopper;
import ua.epam.homework.second.data.ShoppingResult;

import java.util.List;

public class DelegateShopper implements Shopper{
	private Shopper shopper;

	public DelegateShopper(Shopper shopper) {
		this.shopper = shopper;
	}

	@Override
	public ShoppingResult buyGoods(List<String> toBuyList){
		return shopper.buyGoods(toBuyList);
	}

}
