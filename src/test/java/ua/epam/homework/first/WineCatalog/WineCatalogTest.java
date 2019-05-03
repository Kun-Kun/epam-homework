/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.homework.first.WineCatalog;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author nmcdo5
 */
public class WineCatalogTest {
    
    private WineCatalog catalog;
    
    public WineCatalogTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    
    @Before
    public void setUp() {
        catalog = new WineCatalog();
    }
    
    @Test
    public void addWine(){
        Assert.assertEquals(0, catalog.getWineList().size());
        catalog.addWine(new WineInformation("Longitude Blanc de Blancs","France", new GregorianCalendar(2017, 3 , 24)));
        Assert.assertEquals(1, catalog.getWineList().size());
    }
       
    @Test
    public void deleteWine(){
        WineInformation wine = new WineInformation("Longitude Blanc de Blancs","France", new GregorianCalendar(2017, 3 , 24));
        catalog.addWine(wine);
        Assert.assertEquals(1, catalog.getWineList().size());
        catalog.deleteWine(wine);
        Assert.assertEquals(0, catalog.getWineList().size());

    }
	
	@Test
	public void getWineList(){
		WineInformation wine = new WineInformation("Longitude Blanc de Blancs","France", new GregorianCalendar(2017, 3 , 24));
        catalog.addWine(wine);
        Assert.assertEquals(true, catalog.getWineList().contains(wine));
	}
	
	@Test
	public void calculateAging(){
		LocalDate creatingDate = LocalDate.of(2000, Month.MARCH, 2);
		LocalDate calculatingDate = LocalDate.of(2002, Month.MARCH, 2);
		LocalDate calculatingDate1 = LocalDate.of(2002, Month.MARCH, 1);
		Assert.assertEquals(2,WineCatalog.calculateAging(calculatingDate,creatingDate));
		Assert.assertEquals(1,WineCatalog.calculateAging(calculatingDate1,creatingDate));
	}
    
	@Test
	public void convertToLocalDateViaInstant(){
		Calendar dateToConvert = new GregorianCalendar(2017,3,3);
		LocalDate localDate = LocalDate.of(2017, 4, 3);
		Assert.assertEquals(true, WineCatalog.convertToLocalDateViaInstant(dateToConvert).equals(localDate));
	}
    
	@Test
	public void getWineInformationAsString(){
		WineInformation wine1 = new WineInformation("Longitude Blanc de Blancs","France", new GregorianCalendar(2017, 3 , 24));
		Assert.assertEquals("Longitude Blanc de Blancs from France has 2 years.", WineCatalog.getWineInformationAsString(wine1));
	}
	
	
}
