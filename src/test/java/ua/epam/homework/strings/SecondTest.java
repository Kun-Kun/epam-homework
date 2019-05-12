package ua.epam.homework.strings;

import org.junit.Assert;
import org.junit.Test;

public class SecondTest {
	@Test
	public void sortWordByChar() throws Exception {
		String text = "one twoo threooo null all eight three five zerg";
		String expected = "threooo twoo one all eight five null three zerg";
		String sortedText = SecondTask.sortWordByChar(text,'o');
		Assert.assertEquals(expected,sortedText);
	}

	@Test(expected = NullPointerException.class)
	public void sortWordByCharNullText() throws Exception {
		SecondTask.sortWordByChar(null,'a');
	}
}