package FooBarQix.FooBarQix.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculation utility class 1- Extracting integers from a number string 2-
 * Converting string / integer
 * 
 * @author ilakkis
 *
 */
abstract class FootBarQixAbstract {

	/**
	 * Function for extracting integers from an integer string Example: for the
	 * number 53 , the function returns an array of integers (0 => 5, 1 => 3)
	 * 
	 * @param number
	 * @return
	 */
	public List<Integer> extractIntegersFromNumber(int number) {
		List<Integer> tabIntegers = new ArrayList<Integer>();

		String chaine = convertIntegerToString(number);
		if (chaine.length() > 1) {
			// number (> 9)
			for (int i = 0; i < chaine.length(); i++) {
				tabIntegers.add(convertStringToInteger(chaine.substring(i, i + 1)));
			}
		} else {
			// unity (<10)
			tabIntegers.add(number);
		}

		return tabIntegers;
	}

	protected String convertIntegerToString(int number) {
		return String.valueOf(number);
	}

	protected int convertStringToInteger(String number) {
		return Integer.parseInt(number);
	}

}
