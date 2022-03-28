package FooBarQix.FooBarQix.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * @author ilakkis
 *
 */
public class FootBarQixAbstractTest {

	@Test
	public void extractIntegersFromNumberTest() {
		FootBarQix footBarQix = new FootBarQix(0, 0);

		// example of extracting number : 535782
		List<Integer> entiers = footBarQix.extractIntegersFromNumber(535782);

		assertTrue(entiers.size() == 6);

		assertTrue(entiers.get(0) == 5);
		assertTrue(entiers.get(1) == 3);
		assertTrue(entiers.get(2) == 5);
		assertTrue(entiers.get(3) == 7);
		assertTrue(entiers.get(4) == 8);
		assertTrue(entiers.get(5) == 2);
	}

}
