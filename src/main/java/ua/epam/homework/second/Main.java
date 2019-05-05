package ua.epam.homework.second;

import ua.epam.homework.second.data.Goods;
import ua.epam.homework.second.impl.Husband;
import ua.epam.homework.second.impl.SimpleStore;
import ua.epam.homework.second.impl.Wife;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		SimpleStore groceryStore = new SimpleStore();
		groceryStore.putProduct(new Goods("Bread",110f));
		groceryStore.putProduct(new Goods("Sausage",80f));
		groceryStore.putProduct(new Goods("Butter",70f));
		groceryStore.putProduct(new Goods("Milk",300f));
		groceryStore.putProduct(new Goods("Potato",40f));

		SimpleStore applianceShop = new SimpleStore();
		applianceShop.putProduct(new Goods("Sony",100f));
		applianceShop.putProduct(new Goods("Samsung",80f));
		applianceShop.putProduct(new Goods("Sharp",70f));
		applianceShop.putProduct(new Goods("Apple",300f));
		applianceShop.putProduct(new Goods("Aser",40f));

		List<String> toBuyList = new ArrayList();
		toBuyList.add("Sony");
		toBuyList.add("Bread");
		toBuyList.add("Vodka");
		toBuyList.add("Coco");



		Husband husband = new Husband();
		husband.memorizeShop(groceryStore);
		husband.memorizeShop(applianceShop);




		Wife wife = new Wife(husband);
		wife.doShopping(toBuyList);
	}
}
