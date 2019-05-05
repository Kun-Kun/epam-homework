package ua.epam.homework.second.data;

import ua.epam.homework.second.api.Buyable;

import java.util.List;

public class ShoppingResult {
	List<Buyable> allProductList;
	List<Buyable> purchasedProductList;
	Float totalPrice;

	public List<Buyable> getAllProductList() {
		return allProductList;
	}

	public void setAllProductList(List<Buyable> allProductList) {
		this.allProductList = allProductList;
	}

	public List<Buyable> getPurchasedProductList() {
		return purchasedProductList;
	}

	public void setPurchasedProductList(List<Buyable> purchasedProductList) {
		this.purchasedProductList = purchasedProductList;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
}
