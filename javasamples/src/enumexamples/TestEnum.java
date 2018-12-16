package enumexamples;

public class TestEnum {

    public static void main(String[] args) {

	Enum en = ColorEnum.GREEN;

	System.out.println(en.toString());

	/**
	 * at java.lang.Enum.valueOf(Enum.java:238) at
	 * enumexamples.ColorEnumWithName.valueOf(ColorEnumWithName.java:1) at
	 * enumexamples.TestEnum.main(TestEnum.java:11)
	 */
	// Enum enC = ColorEnumWithName.valueOf("YELLOW");
	// System.out.println(enC);
	
	
	Enum<ColorEnumWithName> enCR = ColorEnumWithName.valueOf("RED");
	System.out.println(enCR);
	
	Enum<ColorEnum> enCR2 = ColorEnumWithName.valueOf(ColorEnum.class, "YELLOW");
	System.out.println(enCR2);
	
	System.out.println(ColorEnumWithName.GREEN.getColorDesc());
	
	System.out.println(EnumWithoutInstance.test());
	
	System.out.println(EnumWithoutInstance.test("Arun"));
	
	System.out.println("ordinal of RED: " + ColorEnumWithName.RED.ordinal());
	
	System.out.println("ordinal of GREEN: " + ColorEnumWithName.GREEN.ordinal());


	
	
    }

}
