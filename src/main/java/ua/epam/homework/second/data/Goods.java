package ua.epam.homework.second.data;

import ua.epam.homework.second.api.Buyable;

public class Goods implements Buyable {
	private String name;
	private Float price;

	public Goods(String name, Float price) {
		this.name = name;
		this.price = price;
	}


	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return name + " - " + price;
	}
}
