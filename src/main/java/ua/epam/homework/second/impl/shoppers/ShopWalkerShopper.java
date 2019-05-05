package ua.epam.homework.second.impl.shoppers;

import ua.epam.homework.second.api.Buyable;
import ua.epam.homework.second.api.ShopForUser;
import ua.epam.homework.second.api.Shopper;
import ua.epam.homework.second.data.ShoppingResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShopWalkerShopper implements Shopper {

	private Set<ShopForUser> knownShops;

	public ShopWalkerShopper(Set<ShopForUser> knownShops) {
		this.knownShops = knownShops;
	}

	public ShopWalkerShopper(List<ShopForUser> knownShops) {
		this.knownShops = new HashSet<>(knownShops);
	}

	public ShopWalkerShopper() {
		this.knownShops = new HashSet<>();
	}

	public void setKnownShops(Set<ShopForUser> knownShops) {
		this.knownShops = knownShops;
	}

	public void memorizeShop(ShopForUser shop) {
		this.knownShops.add(shop);
	}

	@Override
	public ShoppingResult buyGoods(List<String> toBuyList){
		List<Buyable> allProductList = knownShops.stream().
				map(ShopForUser::getAllProductsList).
				flatMap(List::stream).
				collect(Collectors.toList());
		List<Buyable> purchasedProductList = knownShops.stream().
				map(shop -> shop.orderProducts(toBuyList)).
				flatMap(List::stream).
				collect(Collectors.toList());
		Float totalPrice = (float)purchasedProductList.stream().
				mapToDouble(Buyable::getPrice).
				sum();
		ShoppingResult shoppingResult = new ShoppingResult();
		shoppingResult.setAllProductList(allProductList);
		shoppingResult.setPurchasedProductList(purchasedProductList);
		shoppingResult.setTotalPrice(totalPrice);
		return shoppingResult;
	}

}
