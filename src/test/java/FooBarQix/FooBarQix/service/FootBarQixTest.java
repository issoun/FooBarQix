package FooBarQix.FooBarQix.service;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ilakkis
 *
 */
public class FootBarQixTest {

	private static String FOO = "";
	private static String BAR = "";
	private static String QIX = "";
	private static String SEP = "";

	@Before
	public void initialize() throws IllegalAccessException {
		FOO = getFieldFromVariable(FOO, "FIELD_1");
		BAR = getFieldFromVariable(BAR, "FIELD_2");
		QIX = getFieldFromVariable(QIX, "FIELD_3");
		SEP = getFieldFromVariable(SEP, "SEPARATOR");
	}

	/**
	 * @param field
	 * @param setTo
	 * @throws IllegalAccessException
	 */
	private String getFieldFromVariable(String field, String setTo) throws IllegalAccessException {
		try {
			FootBarQix fbq = new FootBarQix(0, 0);
			Field field1 = FootBarQix.class.getDeclaredField(setTo);
			field1.setAccessible(true);
			return (String) field1.get(fbq);			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * divisors have high precedence, ex: 51 -> FooBar the content is analysed in
	 * the order they appear, ex: 53 -> BarFoo 13 contains 3 so we print "Foo" 15 is
	 * divisible by 3 and 5 and contains 5, so we print “FooBarBar” 33 contains 3
	 * two times and is divisible by 3, so we print “FooFooFoo” 27 is divisible by 3
	 * and contains 7, so we print "FooQix"
	 */
	@Test
	public void us1_Test() throws IllegalArgumentException, IllegalAccessException {
		FootBarQix footBarQix1 = new FootBarQix(51, 51);
		assertEquals(footBarQix1.result, FOO + BAR + SEP);

		FootBarQix footBarQix2 = new FootBarQix(53, 53);
		assertEquals(footBarQix2.result, BAR + FOO + SEP);

		FootBarQix footBarQix3 = new FootBarQix(13, 13);
		assertEquals(footBarQix3.result, FOO + SEP);

		FootBarQix footBarQix4 = new FootBarQix(15, 15);
		assertEquals(footBarQix4.result, FOO + BAR + BAR + SEP);

		FootBarQix footBarQix5 = new FootBarQix(33, 33);
		assertEquals(footBarQix5.result, FOO + FOO + FOO + SEP);

		FootBarQix footBarQix6 = new FootBarQix(27, 27);
		assertEquals(footBarQix6.result, FOO + QIX + SEP);
	}

	/*
	 * Optonnal - what are we obtain from one to cent ?
	 */
	@Test
	public void us2_Test() {
		FootBarQix footBarQix1 = new FootBarQix(1, 100);
		String fromOneToCent = "1" + SEP + "2" + SEP + FOO + FOO + SEP + "4" + SEP + BAR + BAR + SEP + FOO + SEP + QIX
				+ SEP + "8" + SEP + FOO + SEP + BAR + SEP + "11" + SEP + FOO + SEP + FOO + SEP + "14" + SEP + FOO + BAR
				+ BAR + SEP + "16" + SEP + QIX + SEP + FOO + SEP + "19" + SEP + BAR + SEP + FOO + SEP + "22" + SEP + FOO
				+ SEP + FOO + SEP + BAR + BAR + SEP + "26" + SEP + FOO + QIX + SEP + "28" + SEP + "29" + SEP + FOO + BAR
				+ FOO + SEP + FOO + SEP + FOO + SEP + FOO + FOO + FOO + SEP + FOO + SEP + BAR + FOO + BAR + SEP + FOO
				+ FOO + SEP + FOO + QIX + SEP + FOO + SEP + FOO + FOO + SEP + BAR + SEP + "41" + SEP + FOO + SEP + FOO
				+ SEP + "44" + SEP + FOO + BAR + BAR + SEP + "46" + SEP + QIX + SEP + FOO + SEP + "49" + SEP + BAR + BAR
				+ SEP + FOO + BAR + SEP + BAR + SEP + BAR + FOO + SEP + FOO + BAR + SEP + BAR + BAR + BAR + SEP + BAR
				+ SEP + FOO + BAR + QIX + SEP + BAR + SEP + BAR + SEP + FOO + BAR + SEP + "61" + SEP + "62" + SEP + FOO
				+ FOO + SEP + "64" + SEP + BAR + BAR + SEP + FOO + SEP + QIX + SEP + "68" + SEP + FOO + SEP + BAR + QIX
				+ SEP + QIX + SEP + FOO + QIX + SEP + QIX + FOO + SEP + QIX + SEP + FOO + BAR + QIX + BAR + SEP + QIX
				+ SEP + QIX + QIX + SEP + FOO + QIX + SEP + QIX + SEP + BAR + SEP + FOO + SEP + "82" + SEP + FOO + SEP
				+ FOO + SEP + BAR + BAR + SEP + "86" + SEP + FOO + QIX + SEP + "88" + SEP + "89" + SEP + FOO + BAR + SEP
				+ "91" + SEP + "92" + SEP + FOO + FOO + SEP + "94" + SEP + BAR + BAR + SEP + FOO + SEP + QIX + SEP
				+ "98" + SEP + FOO + SEP + BAR + SEP;
		assertEquals(footBarQix1.result, fromOneToCent);
	}

	/*
	 * what are we obtain from 950 to 1000 ?
	 */
	@Test
	public void us3_Test() {
		FootBarQix footBarQix1 = new FootBarQix(950, 1000);
		String from950To1000 = BAR + BAR + SEP + FOO + BAR + SEP + BAR + SEP + BAR + FOO + SEP + FOO + BAR + SEP + BAR
				+ BAR + BAR + SEP + BAR + SEP + FOO + BAR + QIX + SEP + BAR + SEP + BAR + SEP + FOO + BAR + SEP + "961"
				+ SEP + "962" + SEP + FOO + FOO + SEP + "964" + SEP + BAR + BAR + SEP + FOO + SEP + QIX + SEP + "968"
				+ SEP + FOO + SEP + BAR + QIX + SEP + QIX + SEP + FOO + QIX + SEP + QIX + FOO + SEP + QIX + SEP + FOO
				+ BAR + QIX + BAR + SEP + QIX + SEP + QIX + QIX + SEP + FOO + QIX + SEP + QIX + SEP + BAR + SEP + FOO
				+ SEP + "982" + SEP + FOO + SEP + FOO + SEP + BAR + BAR + SEP + "986" + SEP + FOO + QIX + SEP + "988"
				+ SEP + "989" + SEP + FOO + BAR + SEP + "991" + SEP + "992" + SEP + FOO + FOO + SEP + "994" + SEP + BAR
				+ BAR + SEP + FOO + SEP + QIX + SEP + "998" + SEP + FOO + SEP + BAR + SEP;
		assertEquals(footBarQix1.result, from950To1000);
	}

	/*
	 * what are we obtain from million to million 50 ?
	 */
	@Test
	public void us4_Test() {
		FootBarQix footBarQix1 = new FootBarQix(1000000, 1000050);
		String fromMillion0ToMillion50 = BAR + SEP + "1000001" + SEP + FOO + SEP + FOO + SEP + "1000004" + SEP + FOO
				+ BAR + BAR + SEP + "1000006" + SEP + QIX + SEP + FOO + SEP + "1000009" + SEP + BAR + SEP + FOO + SEP
				+ "1000012" + SEP + FOO + SEP + FOO + SEP + BAR + BAR + SEP + "1000016" + SEP + FOO + QIX + SEP
				+ "1000018" + SEP + "1000019" + SEP + FOO + BAR + SEP + "1000021" + SEP + "1000022" + SEP + FOO + FOO
				+ SEP + "1000024" + SEP + BAR + BAR + SEP + FOO + SEP + QIX + SEP + "1000028" + SEP + FOO + SEP + BAR
				+ FOO + SEP + FOO + SEP + FOO + FOO + SEP + FOO + FOO + SEP + FOO + SEP + FOO + BAR + FOO + BAR + SEP
				+ FOO + SEP + FOO + QIX + SEP + FOO + FOO + SEP + FOO + SEP + BAR + SEP + FOO + SEP + "1000042" + SEP
				+ FOO + SEP + FOO + SEP + BAR + BAR + SEP + "1000046" + SEP + FOO + QIX + SEP + "1000048" + SEP
				+ "1000049" + SEP + FOO + BAR + BAR + SEP;
		assertEquals(footBarQix1.result, fromMillion0ToMillion50);
	}

}
