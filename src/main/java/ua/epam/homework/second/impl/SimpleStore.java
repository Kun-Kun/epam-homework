package ua.epam.homework.second.impl;

import ua.epam.homework.second.api.Buyable;
import ua.epam.homework.second.api.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleStore implements Shop {
	private List<Buyable> goods;

	public SimpleStore(List<Buyable> goods) {
		this.goods = goods;
	}

	public SimpleStore() {
		goods = new ArrayList<>();
	}

	@Override
	public void putProduct(Buyable product){
		if(product!=null){
			goods.add(product);
		}
	}

	@Override
	public void removeProduct(Buyable product){
		goods.remove(product);
	}

	@Override
	public List<Buyable> getOriginalProductList(){
		return goods;
	}

	@Override
	public List<Buyable> getAllProductsList(){
		return new ArrayList<>(goods);
	}

	@Override
	public List<Buyable> orderProducts(List<String> wanted) {
		return goods.stream().
				filter(buyable -> wanted.contains(buyable.getName())).
				collect(Collectors.toList());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SimpleStore)) return false;

		SimpleStore that = (SimpleStore) o;

		return goods != null ? goods.equals(that.goods) : that.goods == null;
	}

	@Override
	public int hashCode() {
		return goods != null ? goods.hashCode() : 0;
	}
}
