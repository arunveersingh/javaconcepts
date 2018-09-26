package javasamples;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalSamples {

	public static void main(String[] args) {
		BigDecimal x = new BigDecimal(16.0, new MathContext(4));
		
		
		x = new BigDecimal(22.00, new MathContext(16)).setScale(4);
		//x = x.setScale(4);
		System.out.println(x);

	}

}
