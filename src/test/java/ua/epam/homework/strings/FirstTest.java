package ua.epam.homework.strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.core.Is.is;

public class FirstTest {
	@Test
	public void sortByFrequencyCaseSensitive() throws Exception {
		String text = "One two three two three one three";
		List<String> listToSort = new ArrayList<>();
		listToSort.add("three");
		listToSort.add("one");
		listToSort.add("two");
		List<String> sortedList = FirstTask.sortByFrequencyCaseSensitive(listToSort, text);
		Assert.assertThat(sortedList, contains("three", "two", "one"));
	}

	@Test
	public void sortByFrequencyCaseSensitive1() throws Exception {
		String text = "One two three two three one three";
		List<String> listToSort = new ArrayList<>();
		listToSort.add("three");
		listToSort.add("one");
		listToSort.add("two");
		listToSort.add("zero");
		List<String> sortedList = FirstTask.sortByFrequencyCaseSensitive(listToSort, text);
		Assert.assertThat(sortedList, contains("three", "two", "one", "zero"));
	}

	@Test
	public void sortByFrequencyCaseSensitiveDuplicates() throws Exception {
		String text = "One two three two three one three";
		List<String> listToSort = new ArrayList<>();
		listToSort.add("three");
		listToSort.add("one");
		listToSort.add("two");
		listToSort.add("two");
		listToSort.add("zero");
		List<String> sortedList = FirstTask.sortByFrequencyCaseSensitive(listToSort, text);
		Assert.assertThat(sortedList, contains("three", "two", "one", "zero"));
	}

	@Test
	public void sortByFrequencyCaseSensitiveWithNullInList() throws Exception {
		String text = "One two three two three one three";
		List<String> listToSort = new ArrayList<>();
		listToSort.add(null);
		listToSort.add("One");
		List<String> sortedList = FirstTask.sortByFrequencyCaseSensitive(listToSort, text);
		Assert.assertThat(sortedList, contains("One", null));
	}

	@Test(expected = NullPointerException.class)
	public void sortByFrequencyCaseSensitiveWithNullList() throws Exception {
		String text = "One two three two three one three";
		List<String> listToSort = null;
		FirstTask.sortByFrequencyCaseSensitive(listToSort, text);
	}

	@Test(expected = NullPointerException.class)
	public void sortByFrequencyCaseSensitiveWithNullText() throws Exception {
		String text = null;
		List<String> listToSort = new ArrayList<>();
		listToSort.add("One");
		FirstTask.sortByFrequencyCaseSensitive(listToSort, text);
	}


	@Test
	public void sortByFrequencyCaseSensitiveEmptyList() throws Exception {
		String text = "One two three two three one three";
		List<String> listToSort = new ArrayList<>();
		List<String> sortedList = FirstTask.sortByFrequencyCaseSensitive(listToSort, text);
		Assert.assertThat(sortedList, is(emptyIterable()));
	}

	@Test
	public void sortByFrequency() throws Exception {
		String text = "Two two three thrEE ONE three";
		List<String> listToSort = new ArrayList<>();
		listToSort.add("three");
		listToSort.add("one");
		listToSort.add("two");
		List<String> sortedList = FirstTask.sortByFrequency(listToSort, text);
		Assert.assertThat(sortedList, contains("three", "two", "one"));
	}

	@Test
	public void sortByFrequency1() throws Exception {
		String text = "Two two three thrEE ONE three";
		List<String> listToSort = new ArrayList<>();
		listToSort.add("THREE");
		listToSort.add("onE");
		listToSort.add("tWo");
		List<String> sortedList = FirstTask.sortByFrequency(listToSort, text);
		Assert.assertThat(sortedList, contains("THREE", "tWo", "onE"));
	}

	@Test
	public void sortByFrequencySameKey() throws Exception {
		String text = "Two two three thrEE ONE three";
		List<String> listToSort = new ArrayList<>();
		listToSort.add("THREE");
		listToSort.add("onE");
		listToSort.add("tWo");
		listToSort.add("TWo");
		List<String> sortedList = FirstTask.sortByFrequency(listToSort, text);
		Assert.assertThat(sortedList, contains("THREE", "TWo", "onE"));
	}

	@Test
	public void sortByFrequencyWithNullInList() throws Exception {
		String text = "One two three two three one three";
		List<String> listToSort = new ArrayList<>();
		listToSort.add(null);
		listToSort.add("One");
		List<String> sortedList = FirstTask.sortByFrequency(listToSort, text);
		Assert.assertThat(sortedList, contains("One", null));
	}

	@Test(expected = NullPointerException.class)
	public void sortByFrequencyWithNullList() throws Exception {
		String text = "One two three two three one three";
		List<String> listToSort = null;
		FirstTask.sortByFrequency(listToSort, text);
	}

	@Test(expected = NullPointerException.class)
	public void sortByFrequencyWithNullText() throws Exception {
		String text = null;
		List<String> listToSort = new ArrayList<>();
		listToSort.add("One");
		FirstTask.sortByFrequency(listToSort, text);
	}


	@Test
	public void sortByFrequencyEmptyList() throws Exception {
		String text = "One two three two three one three";
		List<String> listToSort = new ArrayList<>();
		List<String> sortedList = FirstTask.sortByFrequency(listToSort, text);
		Assert.assertThat(sortedList, is(emptyIterable()));
	}

}