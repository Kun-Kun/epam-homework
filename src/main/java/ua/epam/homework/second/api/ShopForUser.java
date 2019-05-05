package ua.epam.homework.second.api;

import java.util.List;

public interface ShopForUser {
	List<Buyable> getAllProductsList();
	List<Buyable> orderProducts(List<String> wanted);
}
