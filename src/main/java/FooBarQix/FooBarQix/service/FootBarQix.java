package FooBarQix.FooBarQix.service;

import java.util.List;

/**
 * Calculation main class
 * 
 * @author ilakkis
 *
 */
public class FootBarQix extends FootBarQixAbstract {

	private static final String FIELD_1 = "Foo"; // note : possible update to other words. Ex :"coffee"
	private static final String FIELD_2 = "Bar"; // note : possible update to other words. Ex :"tea"
	private static final String FIELD_3 = "Qix"; // note : possible update to other words. Ex :"sugar"
	private static final String SEPARATOR = " "; // note : possible update to "-" or "____ " or ";", etc....

	private final int fromInt;
	private final int toInt;

	private boolean isNumberReplaced = false;
	public String result = ""; // calculation result

	/**
	 * Constructor
	 * 
	 * @param fromInt
	 * @param toInt
	 */
	public FootBarQix(int fromInt, int toInt) {
		super();
		this.fromInt = fromInt;
		this.toInt = toInt;
		calculFooBarQix();
	}

	/**
	 * Calculation function
	 */
	private void calculFooBarQix() {
		for (int i = fromInt; i <= toInt; i++) {
			isNumberReplaced = false;

			// 1-first action is testing divisors
			replaceTo(i, 3, FootBarQix.FIELD_1);
			replaceTo(i, 5, FootBarQix.FIELD_2);

			// 2-second action is testing the content in the order they appear
			containsToFooBarQix(i);

			if (!isNumberReplaced) {
				addNumberToPrinter(i);
			}
			addWhiteSpaceToPrinter();
		}
	}

	/**
	 * Divisible/Contains Check Functions
	 * 
	 * @param number
	 * @param element
	 * @return
	 */
	private boolean isNumberDivisibleBy(int number, int element) {
		return (number % element == 0) ? true : false;
	}

	private boolean isNumberContains(int number, int element) {
		return (String.valueOf(number).contains(String.valueOf(element))) ? true : false;
	}

	/**
	 * Replacement functions
	 * 
	 * @param number
	 */
	private void replaceTo(int number, int divisibleBy, String chaineToAdd) {
		if (isNumberDivisibleBy(number, divisibleBy)) {
			result += chaineToAdd;
			isNumberReplaced = true;
		}
	}

	private void containsToFooBarQix(int number) {
		List<Integer> entiers = extractIntegersFromNumber(number);

		for (int i = 0; i < entiers.size(); i++) {
			containsToFoo(entiers.get(i));
			containsToBar(entiers.get(i));
			containsToQix(entiers.get(i));
		}

	}

	private void containsToFoo(int number) {
		if (isNumberContains(number, 3)) {
			result += FIELD_1;
			isNumberReplaced = true;
		}
	}

	private void containsToBar(int number) {
		if (isNumberContains(number, 5)) {
			result += FIELD_2;
			isNumberReplaced = true;
		}
	}

	private void containsToQix(int number) {
		if (isNumberContains(number, 7)) {
			result += FIELD_3;
			isNumberReplaced = true;
		}
	}

	/**
	 * Display functions
	 */
	private void addWhiteSpaceToPrinter() {
		result += SEPARATOR;
	}

	private void addNumberToPrinter(int number) {
		result += number;
	}

}
