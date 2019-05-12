package ua.epam.homework.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class FourthTest {
	@Test
	public void replaceWordLengthWith() throws Exception {
		String text = "Людей, достигших в этом мастерства, иногда именуют «хакерами».";
		String expected = "Людей, достигших в этом мастерства, иногда именуют «ВАСИЛИЙ».";
		String result = FourthTask.replaceWordLengthWith(8,text,"ВАСИЛИЙ");
		assertEquals(result,expected);
	}

	@Test
	public void replaceWordLengthWithNull() throws Exception {
		String text = "Людей, достигших в этом мастерства, иногда именуют «хакерами».";
		String expected = "Людей, достигших в этом мастерства, иногда именуют «null».";
		String result = FourthTask.replaceWordLengthWith(8,text,null);
		assertEquals(result,expected);
	}

	@Test(expected = NullPointerException.class)
	public void replaceWordLengthWithNullText() throws Exception {
		FourthTask.replaceWordLengthWith(8,null,"");

	}

	@Test(expected = IllegalArgumentException.class)
	public void replaceWordLengthWithNegativeLength() throws Exception {
		String text = "Людей, достигших в этом мастерства, иногда именуют «хакерами».";
		FourthTask.replaceWordLengthWith(-1,text,"ВАСИЛИЙ");
	}

}