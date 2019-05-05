package ua.epam.homework.second.api;

import java.util.List;

public interface ShopForAdmin {
	void putProduct(Buyable product);
	void removeProduct(Buyable product);
	List<Buyable> getOriginalProductList();
}
