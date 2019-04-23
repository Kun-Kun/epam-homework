package ua.epam.homework.WineCatalog;

import java.util.Calendar;
import java.util.Date;


public class WineInformation {
	private String name;
	private String country;
	private Calendar bottlingDate;

	public WineInformation(String name, String country, Calendar bottlingDate) {
		this.name = name;
		this.country = country;
		this.bottlingDate = bottlingDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Calendar getBottlingDate() {
		return bottlingDate;
	}

	public void setBottlingDate(Calendar bottlingDate) {
		this.bottlingDate = bottlingDate;
	}
}
