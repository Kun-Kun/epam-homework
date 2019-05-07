package ua.epam.homework.second.data;

import java.util.Objects;
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

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 53 * hash + Objects.hashCode(this.name);
		hash = 53 * hash + Objects.hashCode(this.price);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Goods other = (Goods) obj;
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.price, other.price)) {
			return false;
		}
		return true;
	}
	
	
}
