package ua.epam.homework.second.api;

import ua.epam.homework.second.data.ShoppingResult;

import java.util.List;

public interface Shopper {
	ShoppingResult buyGoods(List<String> toBuyList);
}