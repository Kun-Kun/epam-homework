package ua.epam.homework.second;

public class Goods implements Buyable {
	private String name;
	private Float price;

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


}
