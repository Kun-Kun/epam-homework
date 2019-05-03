package ua.epam.homework.first.WineCatalog;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

public class WineCatalog {
	private List<WineInformation> wineList = new ArrayList<>();
        
	public void addWine(WineInformation wine){
		wineList.add(wine);
	}

	public void deleteWine(WineInformation wine){
		wineList.remove(wine);
	}

	public List<WineInformation> getWineList(){
		return new ArrayList<>(wineList);
	}

	public static int calculateAging(LocalDate currentDate, LocalDate wineDate){
		return Period.between(wineDate,currentDate).getYears();
	}
	
	public static int calculateWineAging(WineInformation wineInformation){
		LocalDate currentDate = convertToLocalDateViaInstant(Calendar.getInstance());
		LocalDate wineDate = convertToLocalDateViaInstant(wineInformation.getBottlingDate());
		return calculateAging(currentDate, wineDate);
	}


	public static LocalDate convertToLocalDateViaInstant(Calendar dateToConvert) {
		return dateToConvert.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}

	public static String getWineInformationAsString(WineInformation wineInformation){
		StringBuilder builder = new StringBuilder();
		builder.append(wineInformation.getName())
				.append(" from ")
                .append(wineInformation.getCountry())
				.append(" has ")
				.append(WineCatalog.calculateWineAging(wineInformation))
				.append(" years.");
		return builder.toString();
	}

	public void printCatalog(){
		System.out.println("Catalog:");
		for (WineInformation wineInformation:wineList){
			System.out.println(getWineInformationAsString(wineInformation));
		}
	}


	public static void main(String[] args) {
		WineCatalog catalog = new WineCatalog();
		WineInformation wine1 = new WineInformation("Longitude Blanc de Blancs","France", new GregorianCalendar(2017, 3 , 24));
		WineInformation wine2 = new WineInformation("Rosso di Montepulciano","Italy", new GregorianCalendar(2000, 7 , 11));
		WineInformation wine3 = new WineInformation("Lagar de Cervera","Spain", new GregorianCalendar(1990, 10 , 2));

		catalog.addWine(wine1);
		catalog.addWine(wine2);
		catalog.addWine(wine3);

		catalog.printCatalog();
	}
}
